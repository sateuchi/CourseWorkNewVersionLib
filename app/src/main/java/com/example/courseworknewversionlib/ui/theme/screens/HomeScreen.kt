package com.example.courseworknewversionlib.ui.theme.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.courseworknewversionlib.data.Book
import com.example.courseworknewversionlib.ui.theme.BooksUIState

@Composable
fun HomeScreen(
    booksUIState: BooksUIState,
    retryAction: () -> Unit,
    modifier: Modifier = Modifier,
    onBookClicked: (Book) -> Unit
) {
    when (booksUIState){
        is BooksUIState.Loading -> loadingScreen(modifier)
        is BooksUIState.Success -> BooksGridScreen(
            books = booksUIState.bookSearch,
            modifier = modifier,
            onBookClicked
        )
        is BooksUIState.Error -> ErrorScreen(retryAction = retryAction, modifier)
    }
}