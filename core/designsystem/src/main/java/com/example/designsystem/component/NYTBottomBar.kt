package com.example.designsystem.component

import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NotInterested
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.designsystem.navigation.NYTDestinations

@Composable
fun NYTBottomBar(
    navController: NavHostController,
) {

    val items = listOf(
        NYTDestinations.HomeScreen,
        NYTDestinations.Favourite,
        NYTDestinations.Settings
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()

    NavigationBar {
        val currentRoute = navBackStackEntry?.destination?.route
        Log.d("TAG", "NYTBottomBar (currentRoute): $currentRoute")
        items.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = {
                    if (currentRoute != item.route) {
                        navController.navigate(route = item.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                label = { Text(text = item.label.toString()) },
                icon = {
                    Icon(
                        imageVector = item.icon ?: Icons.Default.NotInterested,
                        contentDescription = null
                    )
                }
            )
        }
    }

}