package com.minhnguyen.feature.settings.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.minhnguyen.feature.settings.SettingsScreen

const val SETTINGS_ROUTE = "settings_route"

fun NavController.navigateToSetting(navOptions: NavOptions) = navigate(SETTINGS_ROUTE, navOptions)

fun NavGraphBuilder.settingsScreen() {
    composable(route = SETTINGS_ROUTE) {
        SettingsScreen()
    }
}