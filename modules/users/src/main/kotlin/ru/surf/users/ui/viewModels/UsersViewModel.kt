package ru.surf.users.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.keygenqt.response.extensions.done
import com.keygenqt.response.extensions.error
import com.keygenqt.response.extensions.success
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import ru.surf.core.extension.withTransaction
import ru.surf.core.utils.ConstantsPaging
import ru.surf.users.data.models.UserModel
import ru.surf.users.data.preferences.UsersPreferences
import ru.surf.users.paging.UsersPageSource
import ru.surf.users.paging.UsersRemoteMediator
import ru.surf.users.services.apiService.UsersApiService
import ru.surf.users.services.dataService.UsersDataService
import timber.log.Timber
import javax.inject.Inject


@HiltViewModel
class UsersViewModel @Inject constructor(
    private val apiService: UsersApiService,
    private val dataService: UsersDataService,
    preferences: UsersPreferences,
) : ViewModel() {

    private val _error404: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val error404: StateFlow<Boolean> get() = _error404.asStateFlow()

    private val _loading: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val loading: StateFlow<Boolean> get() = _loading.asStateFlow()

    private val _search: MutableStateFlow<String?> = MutableStateFlow(null)
    val search = _search.asStateFlow()

    @OptIn(ExperimentalPagingApi::class)
    val listUsers: Flow<PagingData<UserModel>> = Pager(
        config = PagingConfig(pageSize = ConstantsPaging.PAGE_LIMIT),
        remoteMediator = UsersRemoteMediator(apiService, dataService, preferences)
    ) {
        dataService.pagingListUserModel()
    }.flow

    val searchListUsers: Flow<PagingData<UserModel>> = Pager(PagingConfig(pageSize = ConstantsPaging.PAGE_LIMIT)) {
        UsersPageSource(_search.value, apiService)
    }.flow.cachedIn(viewModelScope)

    fun search(search: String?) {
        _search.value = search
    }

    fun getUser(userId: String) = dataService.getUserModel(userId).distinctUntilChanged()

    fun updateUser(userId: String) {
        _loading.value = true
        _error404.value = false
        viewModelScope.launch {
            // update settings
            apiService.updateUser(userId)
                .success { model ->
                    dataService.withTransaction<UsersDataService> {
                        insertUserModel(model)
                    }
                }.error {
                    _error404.value = true
                    Timber.e(it)
                }.done {
                    _loading.value = false
                }
        }
    }
}
