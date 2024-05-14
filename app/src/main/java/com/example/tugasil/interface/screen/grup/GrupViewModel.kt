package com.example.tugasil.`interface`.screen.grup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tugasil.`interface`.UiState
import com.example.tugasil.data.DataConf
import com.example.tugasil.model.FavArtis
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class GrupViewModel(private val repository: DataConf) : ViewModel() {

    private val _uiState: MutableStateFlow<UiState<List<FavArtis>>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<FavArtis>>> get() = _uiState

    fun getAllArtisList() {
        viewModelScope.launch {
            repository.getAllArtisList()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect { listArtis ->
                    _uiState.value = UiState.Success(listArtis)
                }
        }
    }
}