package com.minhnguyen.search.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.minhnguyen.search.SearchRoute

const val SEARCH_ROUTE = "search_route"

fun NavController.navigateToSearch(navOptions: NavOptions) = navigate(SEARCH_ROUTE, navOptions)

fun NavGraphBuilder.searchScreen(navigateToCityList: () -> Unit) {
    composable(route = SEARCH_ROUTE) {
        SearchRoute(navigateToListCity = navigateToCityList)
    }
}