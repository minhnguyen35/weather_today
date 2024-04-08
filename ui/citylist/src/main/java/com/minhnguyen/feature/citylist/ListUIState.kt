package com.minhnguyen.feature.citylist

import com.example.models.UICity

sealed interface FavoriteCityUiState {
    /**
     * The feed is still loading.
     */
    data object Loading : FavoriteCityUiState

    /**
     * The feed is loaded with the given list of news resources.
     */
    data class Success(
        /**
         * The list of news resources contained in this feed.
         */
        val feed: List<UICity>,
    ) : FavoriteCityUiState
}