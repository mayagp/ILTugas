package com.example.tugasil.`interface`.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tugasil.`interface`.UiState
import com.example.tugasil.data.DataConf
import com.example.tugasil.model.Artis
import com.example.tugasil.model.FavArtis
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailViewModel(private val repository: DataConf) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<FavArtis>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<FavArtis>>
        get() = _uiState

    fun getKpopById(artisId : Long){
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(repository.getArtisById(artisId))
        }
    }


}