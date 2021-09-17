package ru.surf.other.ui.viewModels

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.surf.other.services.apiService.OtherApiService
import javax.inject.Inject

@HiltViewModel
class OtherViewModel @Inject constructor(
    apiService: OtherApiService,
) : ViewModel() {

}
