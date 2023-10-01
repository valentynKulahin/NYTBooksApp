package com.example.designsystem.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NYTDestinations(val route: String, val icon: ImageVector?, val label: String? = null) {

    data object HomeScreen : NYTDestinations(route = "home", icon = Icons.Default.Home, label = "Home")

    data object Favourite : NYTDestinations(route = "favourite", icon = Icons.Default.Favorite, label = "Favourite")

    data object Settings : NYTDestinations(route = "settings", icon = Icons.Default.Settings, label = "Settings")

    data object Books : NYTDestinations(route = "books", icon = null, label = "Books")

}