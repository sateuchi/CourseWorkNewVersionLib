package com.example.courseworknewversionlib.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import coil.network.HttpException
import com.example.courseworknewversionlib.BooksApplication
import com.example.courseworknewversionlib.data.Book
import com.example.courseworknewversionlib.data.BooksRepository
import kotlinx.coroutines.launch
import okio.IOException

sealed interface BooksUIState{
    data class Success(val bookSearch: List<Book>): BooksUIState
    object Error: BooksUIState
    object Loading: BooksUIState
}

class BooksViewModel(
    private val booksRepository: BooksRepository
): ViewModel() {

    var booksUIState: BooksUIState by mutableStateOf(BooksUIState.Loading)
        private set

    init{
        getBooks()
    }

    fun getBooks(query: String = "book", maxResults: Int = 40){
        viewModelScope.launch {
            booksUIState = BooksUIState.Loading
            booksUIState = try{
                BooksUIState.Success(booksRepository.getBooks(query, maxResults))
            } catch(e: IOException){
                BooksUIState.Error
            } catch (e: HttpException){
                BooksUIState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as BooksApplication)
                val booksRepository = application.container.booksRepository
                BooksViewModel(booksRepository = booksRepository)
            }
        }
    }
}