package com.example.weathertoday.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.example.myui.navigation.HOME_ROUTE
import com.example.myui.navigation.navigateToHome
import com.example.weathertoday.navigation.WeatherTodayNavHost
import com.minhnguyen.feature.citylist.navigation.CITY_LIST_ROUTE
import com.minhnguyen.feature.citylist.navigation.navigateToCityList
import com.minhnguyen.feature.settings.navigation.SETTINGS_ROUTE
import com.minhnguyen.feature.settings.navigation.navigateToSetting
import com.minhnguyen.ui.myui.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherTodayApp(
    modifier: Modifier = Modifier,
    navHostController: NavHostController = rememberNavController()
) {
    val currentDestination: NavDestination? =
        navHostController.currentBackStackEntryAsState().value?.destination
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            bottomBar = {
                WeatherBottomBar(
                    openHome = {
                        navHostController.navigateToHome(navOptions {
                            popUpTo(navHostController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            // Avoid multiple copies of the same destination when
                            // re-selecting the same item
                            launchSingleTop = true
                            // Restore state when re-selecting a previously selected item
                            restoreState = true
                        })
                    },
                    openFavorites = {
                        navHostController.navigateToCityList(navOptions {
                            popUpTo(navHostController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            // Avoid multiple copies of the same destination when
                            // re-selecting the same item
                            launchSingleTop = true
                            // Restore state when re-selecting a previously selected item
                            restoreState = true
                        })
                    },
                    openSettings = {
                        navHostController.navigateToSetting(navOptions {
                            popUpTo(navHostController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            // Avoid multiple copies of the same destination when
                            // re-selecting the same item
                            launchSingleTop = true
                            // Restore state when re-selecting a previously selected item
                            restoreState = true
                        })
                    },
                    currentDestination = currentDestination
                )
            },
            modifier = modifier
        ) { padding ->
            Column(modifier = modifier.padding(padding)) {
                WeatherTodayNavHost(navController = navHostController)
            }
        }
    }

}

@Composable
internal fun WeatherBottomBar(
    modifier: Modifier = Modifier,
    openHome: () -> Unit,
    openFavorites: () -> Unit,
    openSettings: () -> Unit,
    currentDestination: NavDestination?
) {
    NavigationBar(modifier = modifier) {
        NavigationBarItem(
            selected = currentDestination?.route == HOME_ROUTE,
            onClick = openHome,
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.home),
                    contentDescription = stringResource(id = R.string.home_icon)
                )
            })
        NavigationBarItem(
            selected = currentDestination?.route == CITY_LIST_ROUTE,
            onClick = openFavorites,
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.list),
                    contentDescription = stringResource(id = R.string.list_favorites)
                )
            })
        NavigationBarItem(
            selected = currentDestination?.route == SETTINGS_ROUTE,
            onClick = openSettings,
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.setting),
                    contentDescription = stringResource(id = R.string.setting_icon)
                )
            })
    }
}

@Preview(name = "Top App Bar", showBackground = true)
@Composable
private fun BottomBarPrev() {
    MaterialTheme {
        WeatherBottomBar(Modifier, {}, {}, {},null)
    }
}
