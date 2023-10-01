package com.example.favourite

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.designsystem.component.NYTBackground

@Composable
fun FavouriteScreen(
    navController: NavHostController
) {

    NYTBackground(modifier = Modifier.fillMaxSize()) {
        Text(text = "FAVOURITE SCREEN")
    }

}