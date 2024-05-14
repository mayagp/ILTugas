package com.example.tugasil.`interface`.screen.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tugasil.`interface`.UiState
import com.example.tugasil.data.DataConf
import com.example.tugasil.model.FavArtis
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: DataConf) : ViewModel() {

    private val _uiState: MutableStateFlow<UiState<List<FavArtis>>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<FavArtis>>> get() = _uiState


    fun getAllArtisList() {
        viewModelScope.launch {
            repository.getAllArtisList()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect { artisKpop->
                    _uiState.value = UiState.Success(artisKpop)
                }
        }
    }
    private val _query = mutableStateOf("")
    val query: State<String> get() = _query

        }
