package com.example.weathertoday.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.navOptions

enum class TopLevelDestination(
//    val selectedIcon: ImageVector,
//    val unselectedIcon: ImageVector,
//    val iconTextId: Int,
    val titleTextId: String,
) {
    HOME(
//        selectedIcon = NiaIcons.Upcoming,
//        unselectedIcon = NiaIcons.UpcomingBorder,
//        iconTextId = forYouR.string.feature_foryou_title,
        titleTextId = "Home",
    ),
    FAVORITES(
//        selectedIcon = NiaIcons.Bookmarks,
//        unselectedIcon = NiaIcons.BookmarksBorder,
//        iconTextId = bookmarksR.string.feature_bookmarks_title,
        titleTextId = "Favorites",
    ),
    SETTINGS(
//        selectedIcon = NiaIcons.Grid3x3,
//        unselectedIcon = NiaIcons.Grid3x3,
//        iconTextId = searchR.string.feature_search_interests,
        titleTextId = "Settings",
    ),
}
