package ru.surf.users.ui.viewModels

import androidx.lifecycle.viewModelScope
import androidx.paging.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.surf.core.base.AppViewModel
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
    private val data: UsersDataService,
    private val apiService: UsersApiService,
    private val preferences: UsersPreferences,
) : AppViewModel() {

    override fun clearAfterLogout() {
        preferences.clearAfterLogout()
    }

    private val _search: MutableStateFlow<String?> = MutableStateFlow(null)
    val search = _search.asStateFlow()

    @OptIn(ExperimentalPagingApi::class)
    val listUsers: Flow<PagingData<UserModel>> = Pager(
        config = PagingConfig(pageSize = ConstantsPaging.PAGE_LIMIT),
        remoteMediator = UsersRemoteMediator(data, apiService)
    ) {
        data.pagingListUserModel()
    }.flow

    val searchListUsers: Flow<PagingData<UserModel>> = Pager(PagingConfig(pageSize = ConstantsPaging.PAGE_LIMIT)) {
        UsersPageSource(_search.value, apiService)
    }.flow.cachedIn(viewModelScope)

    fun search(search: String?) {
        _search.value = search
    }
}
