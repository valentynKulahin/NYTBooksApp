package com.example.splash

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.example.designsystem.component.NYTBackground

@Composable
fun SplashScreen() {

    NYTBackground(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SplashScreen_Logo()
        }
    }

}

@Composable
private fun SplashScreen_Logo() {
    Icon(
        imageVector = ImageVector.vectorResource(id = R.drawable.the_new_york_times_logo),
        contentDescription = null
    )
}