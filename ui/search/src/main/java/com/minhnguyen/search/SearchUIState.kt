package com.minhnguyen.search

sealed interface SearchUIState {
    data object Loading: SearchUIState

    data object SearchNotReady: SearchUIState
    data class SearchSuccess (
        val cityList: List<String>
    ): SearchUIState
}