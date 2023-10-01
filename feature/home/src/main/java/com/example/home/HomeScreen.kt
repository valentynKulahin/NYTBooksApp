package com.example.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.designsystem.component.NYTBackground
import com.example.domain.model.category.ResultDomainModel

@Composable
fun HomeScreen(
    navController: NavHostController,
    categoryState: MutableState<String?>,
    homeScreenViewModel: HomeScreenViewModel = hiltViewModel()
) {

    val uiState = homeScreenViewModel.uiState.collectAsStateWithLifecycle()

    NYTBackground(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.Start) {
            HomeScreen_Header()
            HomeScreen_Items(
                navController = navController,
                categoryState = categoryState,
                list = uiState.value.categoriesDomainModel.results
            )
        }
    }

}

@Composable
private fun HomeScreen_Header() {
    Row(modifier = Modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = "Categories", style = MaterialTheme.typography.headlineLarge)
    }
}

@Composable
private fun HomeScreen_Items(
    navController: NavHostController,
    categoryState: MutableState<String?>,
    list: List<ResultDomainModel>
) {
    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        columns = GridCells.Fixed(2)
    ) {
        if (list.isNotEmpty()) {
            items(list) { item ->
                ElevatedCard(
                    modifier = Modifier
                        .padding(8.dp)
                        .height(130.dp)
                        .clickable(
                            interactionSource = MutableInteractionSource(),
                            indication = null,
                            enabled = true,
                            onClick = {
                                categoryState.value = item.display_name.toString()
                                navController.navigate(route = "books")
                            }
                        )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(6.dp),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        HomeScreen_CategoryText(text = item.display_name.toString())
                        HomeScreen_PublishedDate(date = item.newest_published_date.toString())
                    }
                }
            }
        }
    }
}

@Composable
private fun HomeScreen_CategoryText(text: String) {
    Text(text = text)
}

@Composable
private fun HomeScreen_PublishedDate(date: String) {
    Column {
        Text(text = "Published date:")
        Text(text = date)
    }
}