package com.example.books

import android.content.ComponentName
import android.net.Uri
import androidx.browser.customtabs.CustomTabsClient
import androidx.browser.customtabs.CustomTabsIntent
import androidx.browser.customtabs.CustomTabsServiceConnection
import androidx.browser.customtabs.CustomTabsSession
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.designsystem.component.NYTBackground
import com.example.domain.model.full_overview.BookDomainModel

@Composable
fun BooksScreen(
    navController: NavHostController,
    category: String? = null,
    booksScreenViewModel: BooksScreenViewModel = hiltViewModel()
) {

    val uiState = booksScreenViewModel.uiState.collectAsStateWithLifecycle()
    val isLinkClick = remember { mutableStateOf(false) }
    val buyLink = remember { mutableStateOf("") }
    booksScreenViewModel.reducer(intent = BooksScreenIntent.GetBooksFromCategory(category = category.toString()))

    NYTBackground(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(uiState.value.listsDomainModel.books) { item ->
                BooksScreen_Card(item, isLinkClick, buyLink)
            }
        }
    }

    if (isLinkClick.value) {
        WebView(url = buyLink.value)
    }

}

@Composable
private fun BooksScreen_Card(
    item: BookDomainModel,
    isLinkClicked: MutableState<Boolean>,
    buyLink: MutableState<String>
) {
    ElevatedCard(
        modifier = Modifier
//            .wrapContentSize()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
        ) {
            BooksScreen_Card_Image(item.book_image.toString())
            BooksScreen_Card_Details(
                booksName = item.title ?: "",
                author = item.author ?: "",
                publisher = item.publisher ?: "",
                buyLinkItem = item.buy_links.first().url ?: "",
                rank = item.rank ?: 0,
                isLinkClicked = isLinkClicked,
                buyLink = buyLink
            )
        }
        Divider(modifier = Modifier.padding(vertical = 6.dp), thickness = 1.dp)
        BooksScreen_Card_Description(description = item.description ?: "")
    }
}

@Composable
private fun BooksScreen_Card_Image(
    bookImage: String
) {
    AsyncImage(
        model = bookImage, contentDescription = null,
        Modifier
            .height(180.dp)
            .padding(10.dp)
    )
}

@Composable
private fun BooksScreen_Card_Details(
    booksName: String,
    author: String,
    publisher: String,
    buyLinkItem: String,
    rank: Int,
    isLinkClicked: MutableState<Boolean>,
    buyLink: MutableState<String>
) {

    Column {
        Text(text = "Title: $booksName")
        Spacer(modifier = Modifier.height(6.dp))
        Text(text = "Author: $author")
        Spacer(modifier = Modifier.height(6.dp))
        Text(text = "Publisher: $publisher")
        Spacer(modifier = Modifier.height(6.dp))
        Row {
            Text(text = "Buy link: ")
            ClickableText(
                text = AnnotatedString(text = "Link"),
                onClick = {
                    buyLink.value = buyLinkItem
                    isLinkClicked.value = true
                },
                style = TextStyle.Default.copy(color = Color.Blue, fontSize = 16.sp)
            )
        }
        Spacer(modifier = Modifier.height(6.dp))
        Row {
            Text(text = "Rank: $rank")
            Image(imageVector = Icons.Default.StarBorder, contentDescription = null)
        }
    }

}

@Composable
private fun BooksScreen_Card_Description(description: String) {

    val expanded = remember { mutableStateOf(false) }
    Row(horizontalArrangement = Arrangement.SpaceAround) {
        Text(
            modifier = Modifier.clickable { expanded.value = !expanded.value },
            text = "Description: $description",
            maxLines = if (!expanded.value) 2 else Int.MAX_VALUE,
            overflow = TextOverflow.Ellipsis
        )
    }

}

@Composable
fun WebView(
    url: String,
) {
    val context = LocalContext.current
    var mCustomTabsServiceConnection: CustomTabsServiceConnection? = null
    var mClient: CustomTabsClient? = null
    var mCustomTabsSession: CustomTabsSession? = null
    mCustomTabsServiceConnection = object : CustomTabsServiceConnection() {
        override fun onCustomTabsServiceConnected(
            componentName: ComponentName,
            customTabsClient: CustomTabsClient
        ) {
            //Pre-warming
            mClient = customTabsClient
            mClient?.warmup(0L)
            mCustomTabsSession = mClient?.newSession(null)
        }

        override fun onServiceDisconnected(name: ComponentName) {
            mClient = null
        }
    }
    CustomTabsClient.bindCustomTabsService(
        context,
        "com.android.chrome",
        mCustomTabsServiceConnection
    )
    val customTabsIntent = CustomTabsIntent.Builder(mCustomTabsSession)
        //.setToolbarColor(color)
        .setShowTitle(true)
        .build()

    customTabsIntent.launchUrl(context, Uri.parse(url))
}