package com.minhnguyen.search

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
//    private val getSearchResultsUseCase: SearchResultsUseCase,
    private val savedStateHandle: SavedStateHandle
): ViewModel() {
    val searchQuery = savedStateHandle.getStateFlow(key = SEARCH_QUERY, initialValue = "")
//    val uiState: StateFlow<SearchUIState> = getSearchResultsUsecase()

    fun onSearchTriggered(s: String) {
        println("nhbm on search triggered $s")
    }

    fun onSearchQueryChanged(s: String) {
        savedStateHandle[SEARCH_QUERY] = s
    }


    companion object {
        private const val SEARCH_QUERY = "search_query"
    }

}