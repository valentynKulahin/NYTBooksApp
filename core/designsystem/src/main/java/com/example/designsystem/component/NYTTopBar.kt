package com.example.designsystem.component

import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.designsystem.navigation.NYTDestinations

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NYTTopBar(
    navController: NavHostController,
    colors: TopAppBarColors = TopAppBarDefaults.centerAlignedTopAppBarColors()
) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val listTopDestinations = listOf(
        NYTDestinations.HomeScreen.route,
        NYTDestinations.Settings.route,
        NYTDestinations.Favourite.route
    )

    CenterAlignedTopAppBar(
        title = {
            Text(
                text = navBackStackEntry?.destination?.route.toString(),
                maxLines = 1,
                overflow = TextOverflow.Clip
            )
        },
        colors = colors,
        navigationIcon = {
            if (navBackStackEntry?.destination?.route !in listTopDestinations) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    modifier = Modifier.clickable {
                        navController.popBackStack()
                    }
                )
            }
        }
    )

}