package com.example.nytbooksapp.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.books.BooksScreen
import com.example.data.util.NetworkStatus
import com.example.designsystem.component.NYTBackground
import com.example.designsystem.component.NYTBottomBar
import com.example.designsystem.component.NYTTopBar
import com.example.designsystem.navigation.NYTDestinations
import com.example.favourite.FavouriteScreen
import com.example.home.HomeScreen
import com.example.nytbooksapp.MainActivityViewModel
import com.example.nytbooksapp.R
import com.example.settings.SettingsScreen
import com.example.splash.SplashScreen
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NYTBookApp(
    mainActivityViewModel: MainActivityViewModel = hiltViewModel()
) {

    val networkStatus = mainActivityViewModel.networkStatus.collectAsStateWithLifecycle()
    val uiState = mainActivityViewModel.uiState.collectAsStateWithLifecycle()
    val navController = rememberNavController()
    val snackbarHostState = SnackbarHostState()
    val notConnectedMessage = stringResource(id = R.string.not_connected)
    val startAnimation = remember { mutableStateOf(false) }
    val startMainNavigation = remember { mutableStateOf(false) }
    val categoryState = remember { mutableStateOf(uiState.value.category) }

    when (networkStatus.value) {
        NetworkStatus.Disconnected -> {
            LaunchedEffect(networkStatus) {
                snackbarHostState.showSnackbar(message = notConnectedMessage)
            }
        }

        else -> {}
    }

    LaunchedEffect(key1 = true) {
        startAnimation.value = true
        delay(3000L)
        startMainNavigation.value = true
    }
    SplashScreen()

    when (startMainNavigation.value) {
        true -> {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                topBar = { NYTTopBar(navController = navController) },
                bottomBar = { NYTBottomBar(navController = navController) },
                snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
            ) { padding ->
                NYTBackground(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(padding)
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = NYTDestinations.HomeScreen.route
                    ) {
                        composable(route = NYTDestinations.HomeScreen.route) {
                            HomeScreen(
                                navController = navController,
                                categoryState = categoryState
                            )
                        }
                        composable(route = NYTDestinations.Favourite.route) {
                            FavouriteScreen(navController = navController)
                        }
                        composable(route = NYTDestinations.Settings.route) {
                            SettingsScreen(navController = navController)
                        }
                        composable(route = NYTDestinations.Books.route) {
                            BooksScreen(
                                navController = navController,
                                category = categoryState.value
                            )
                        }
                    }
                }
            }
        }

        else -> {}
    }

}