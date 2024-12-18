package com.example.courseworknewversionlib.ui.theme.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.courseworknewversionlib.ui.theme.BooksUIState

@Composable
fun HomeScreen(
    booksUIState: BooksUIState,
    retryAction: () -> Unit,
    modifier: Modifier = Modifier
) {
    when (booksUIState){
        is BooksUIState.Loading -> loadingScreen(modifier)
        is BooksUIState.Success -> BooksGridScreen(
            books = booksUIState.bookSearch,
            modifier = modifier
        )
        is BooksUIState.Error -> ErrorScreen(retryAction = retryAction, modifier)
    }
}