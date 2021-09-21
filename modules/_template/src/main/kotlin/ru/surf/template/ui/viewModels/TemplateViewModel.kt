package ru.surf.template.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.surf.core.utils.ConstantsPaging
import ru.surf.template.data.models.TemplateModel
import ru.surf.template.data.preferences.TemplatePreferences
import ru.surf.template.paging.TemplatePageSource
import ru.surf.template.paging.TemplateRemoteMediator
import ru.surf.template.services.apiService.TemplateApiService
import ru.surf.template.services.dataService.TemplateDataService
import javax.inject.Inject

@HiltViewModel
// @todo {ModuleName|ScreenName}ViewModel
class TemplateViewModel @Inject constructor(
    private val apiService: TemplateApiService,
    private val dataService: TemplateDataService,
    private val preferences: TemplatePreferences,
) : ViewModel() {

    private val _search: MutableStateFlow<String?> = MutableStateFlow(null)
    val search = _search.asStateFlow()

    @OptIn(ExperimentalPagingApi::class)
    // @todo list{ModelName}
    val listTemplate: Flow<PagingData<TemplateModel>> = Pager(
        config = PagingConfig(pageSize = ConstantsPaging.PAGE_LIMIT),
        remoteMediator = TemplateRemoteMediator(apiService, dataService, preferences)
    ) {
        dataService.pagingListTemplateModel()
    }.flow

    // @todo searchList{ModelName}
    val searchListTemplate: Flow<PagingData<TemplateModel>> =
        Pager(PagingConfig(pageSize = ConstantsPaging.PAGE_LIMIT)) {
            TemplatePageSource(_search.value, apiService)
        }.flow.cachedIn(viewModelScope)

    fun search(search: String?) {
        _search.value = search
    }
}
