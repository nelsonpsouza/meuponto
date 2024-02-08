package br.com.nelsonps.meuponto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import br.com.nelsonps.meuponto.ui.components.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen()
        }
    }
}