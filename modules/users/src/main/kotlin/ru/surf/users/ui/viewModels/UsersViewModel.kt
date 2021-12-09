/**
 * Copyright 2021 Surf LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ru.surf.users.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
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
import ru.surfstudio.android.logger.Logger
import ru.surfstudio.compose.response.extensions.done
import ru.surfstudio.compose.response.extensions.error
import ru.surfstudio.compose.response.extensions.success
import javax.inject.Inject

/**
 * [ViewModel] for module
 *
 * @property apiService service http query
 * @property dataService service db room
 * @property preferences service shared preference
 *
 * @author Vitaliy Zarubin
 */
@HiltViewModel
class UsersViewModel @Inject constructor(
    private val apiService: UsersApiService,
    private val dataService: UsersDataService,
    private val preferences: UsersPreferences,
) : ViewModel() {

    /**
     * [MutableStateFlow] state 404 response
     */
    private val _error404: MutableStateFlow<Boolean> = MutableStateFlow(false)

    /**
     * [StateFlow] for [_error404]
     */
    val error404: StateFlow<Boolean> get() = _error404.asStateFlow()

    /**
     * [MutableStateFlow] for loading state
     */
    private val _loading: MutableStateFlow<Boolean> = MutableStateFlow(false)

    /**
     * [StateFlow] for [_loading]
     */
    val loading: StateFlow<Boolean> get() = _loading.asStateFlow()

    /**
     * [MutableStateFlow] for search query
     */
    private val _search: MutableStateFlow<String?> = MutableStateFlow(null)

    /**
     * [StateFlow] for [_search]
     */
    val search = _search.asStateFlow()

    /**
     * List with paging [RemoteMediator]
     */
    @OptIn(ExperimentalPagingApi::class)
    val listUsers: Flow<PagingData<UserModel>> = Pager(
        config = PagingConfig(pageSize = ConstantsPaging.PAGE_LIMIT),
        remoteMediator = UsersRemoteMediator(apiService, dataService, preferences)
    ) {
        dataService.pagingListUserModel()
    }.flow

    /**
     * List with paging [PagingSource]
     */
    val searchListUsers: Flow<PagingData<UserModel>> = Pager(PagingConfig(pageSize = ConstantsPaging.PAGE_LIMIT)) {
        UsersPageSource(_search.value, apiService)
    }.flow.cachedIn(viewModelScope)

    fun search(search: String?) {
        _search.value = search
    }

    /**
     * [Flow] room for view page
     */
    fun getUser(userId: String) = dataService.getUserModel(userId).distinctUntilChanged()

    /**
     * Update view with model [UserModel]
     *
     * @param userId string user identifier
     */
    fun getViewUser(userId: String) {
        _loading.value = true
        _error404.value = false
        viewModelScope.launch {
            // update settings
            apiService.getViewUser(userId)
                .success { model ->
                    dataService.withTransaction<UsersDataService> {
                        insertUserModel(model)
                    }
                }.error {
                    _error404.value = true
                    Logger.w(it)
                }.done {
                    _loading.value = false
                }
        }
    }
}
