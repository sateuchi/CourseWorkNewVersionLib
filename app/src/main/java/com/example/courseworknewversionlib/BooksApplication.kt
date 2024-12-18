package com.example.courseworknewversionlib
import android.app.Application
import com.example.courseworknewversionlib.data.AppContainer
import com.example.courseworknewversionlib.data.DefaultAppContainer

class BooksApplication: Application(){
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()

    }
}