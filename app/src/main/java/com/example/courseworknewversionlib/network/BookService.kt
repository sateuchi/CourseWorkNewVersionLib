package com.example.courseworknewversionlib.network

import com.example.courseworknewversionlib.BookShelf
import retrofit2.http.Query
import retrofit2.http.GET

interface BookService {

    @GET("volumes")
    suspend fun bookSearch(
        @Query("q") searchQuery: String,
        @Query("maxResults") maxResults: Int
    ): BookShelf
}