package com.minhnguyen.feature.citylist.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.minhnguyen.feature.citylist.CityListRoute

const val CITY_LIST_ROUTE = "city_list_route"

fun NavController.navigateToCityList(navOptions: NavOptions) = navigate(CITY_LIST_ROUTE, navOptions)

fun NavGraphBuilder.favoriteCityScreen() {
    composable(route = CITY_LIST_ROUTE) {
        CityListRoute()
    }
}