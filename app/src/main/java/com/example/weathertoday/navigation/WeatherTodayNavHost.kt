package com.example.weathertoday.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.example.myui.HomeScreen
import com.example.myui.navigation.HOME_ROUTE
import com.example.myui.navigation.homeScreen
import com.minhnguyen.feature.citylist.navigation.favoriteCityScreen
import com.minhnguyen.feature.citylist.navigation.navigateToCityList
import com.minhnguyen.feature.settings.navigation.settingsScreen
import com.minhnguyen.search.navigation.navigateToSearch
import com.minhnguyen.search.navigation.searchScreen

@Composable
fun WeatherTodayNavHost(
    modifier: Modifier = Modifier,
    startDestination: String = HOME_ROUTE,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        homeScreen()
        favoriteCityScreen(navigateToSearch = {
            navController.navigateToSearch(navOptions {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                // Avoid multiple copies of the same destination when
                // re-selecting the same item
                launchSingleTop = true
                // Restore state when re-selecting a previously selected item
                restoreState = true
            })
        })
        settingsScreen()
        searchScreen(navigateToCityList = {
            navController.navigateToCityList(navOptions {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                // Avoid multiple copies of the same destination when
                // re-selecting the same item
                launchSingleTop = true
                // Restore state when re-selecting a previously selected item
                restoreState = true
            })
        })
    }
}