package com.example.weathertoday.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.myui.HomeScreen
import com.example.myui.navigation.HOME_ROUTE
import com.example.myui.navigation.homeScreen
import com.minhnguyen.feature.citylist.navigation.favoriteCityScreen
import com.minhnguyen.feature.settings.navigation.settingsScreen
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
        favoriteCityScreen()
        settingsScreen()
        searchScreen()
    }
}