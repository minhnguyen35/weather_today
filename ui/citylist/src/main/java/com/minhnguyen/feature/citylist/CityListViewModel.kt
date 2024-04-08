package com.minhnguyen.feature.citylist

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class CityListViewModel @Inject constructor(): ViewModel() {
    val state: StateFlow<FavoriteCityUiState> = flow {
        emit(FavoriteCityUiState.Loading)
    }.stateIn(scope=viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = FavoriteCityUiState.Loading)
}