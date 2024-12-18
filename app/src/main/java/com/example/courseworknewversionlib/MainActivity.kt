package com.example.courseworknewversionlib

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import com.example.courseworknewversionlib.ui.theme.BooksApp
import com.example.courseworknewversionlib.ui.theme.CourseWorkNewVersionLibTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            BooksApp(
                onBookClicked = {
                    ContextCompat.startActivity(
                        this,
                        Intent(Intent.ACTION_VIEW, Uri.parse(it.previewLink)),
                        null
                    )
                }
            )
        }
    }
}

