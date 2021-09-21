package ru.surf.users.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.surf.core.utils.ConstantsPaging
import ru.surf.users.data.models.UserModel
import ru.surf.users.data.preferences.UsersPreferences
import ru.surf.users.paging.UsersPageSource
import ru.surf.users.paging.UsersRemoteMediator
import ru.surf.users.services.apiService.UsersApiService
import ru.surf.users.services.dataService.UsersDataService
import javax.inject.Inject


@HiltViewModel
class UsersViewModel @Inject constructor(
    private val apiService: UsersApiService,
    private val dataService: UsersDataService,
    preferences: UsersPreferences,
) : ViewModel() {

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
}
