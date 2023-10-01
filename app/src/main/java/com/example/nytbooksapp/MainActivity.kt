package com.example.nytbooksapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.designsystem.theme.NYTBooksAppTheme
import com.example.nytbooksapp.ui.NYTBookApp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NYTBooksAppTheme {
                NYTBookApp()
            }
        }
    }
}