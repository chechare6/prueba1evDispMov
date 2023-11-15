package com.example.prueba1evdispmov

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.prueba1evdispmov.ui.theme.Prueba1evDispMovTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Prueba1evDispMovTheme {
                SumadoraApp()
            }
        }
    }
}

