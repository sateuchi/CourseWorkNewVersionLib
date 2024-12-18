package com.example.courseworknewversionlib.data

import com.example.courseworknewversionlib.network.BookService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AppContainer{


}
class DefaultAppContainer: AppContainer{
    private val BASE_URL = "https://www.goggleapis.com/books/v1/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService: BookService by lazy{
        retrofit.create(BookService::class.java)
    }
}