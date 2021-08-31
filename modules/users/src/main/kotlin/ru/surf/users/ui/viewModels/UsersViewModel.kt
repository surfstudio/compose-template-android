package ru.surf.users.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import ru.surf.users.data.models.UserModel
import ru.surf.users.paging.UsersRemoteMediator
import ru.surf.users.services.apiService.UsersApiService
import ru.surf.users.services.dataService.UsersDataService
import ru.surf.users.utils.ConstantsPaging
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val data: UsersDataService,
    apiService: UsersApiService,
) : ViewModel() {

    @OptIn(ExperimentalPagingApi::class)
    val listUsers: Flow<PagingData<UserModel>> = Pager(
        config = PagingConfig(pageSize = ConstantsPaging.PAGE_LIMIT),
        remoteMediator = UsersRemoteMediator(data, apiService)
    ) {
        data.pagingListUserModel()
    }.flow

}
