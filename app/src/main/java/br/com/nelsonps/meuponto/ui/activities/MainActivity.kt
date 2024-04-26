package br.com.nelsonps.meuponto.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.alura.aluvery.sampledata.sampleRegisters
import br.com.nelsonps.meuponto.ui.screens.HomeScreen
import br.com.nelsonps.meuponto.ui.states.HomeScreenUIState
import br.com.nelsonps.meuponto.ui.theme.MeuPontoTheme
import br.com.nelsonps.meuponto.ui.viewmodels.HomeScreenViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App(
                onFabClick = {
                    startActivity(
                        Intent(
                            this,
                            RegisterFormActivity::class.java
                        )
                    )
                },
                content = {
                    val viewModel by viewModels<HomeScreenViewModel>()
                    HomeScreen("2024-04-26", viewModel)
                }
            )
        }
    }
}

@Composable
fun App(
    onFabClick: () -> Unit = {},
    content: @Composable () -> Unit = {}
) {
    MeuPontoTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Scaffold(
                floatingActionButton = {
                    FloatingActionButton(onClick = onFabClick) {
                        Icon(imageVector = Icons.Default.Add, contentDescription = null)
                    }
                },
                content = { paddingValues ->
                    Box(modifier = Modifier.padding(paddingValues)){
                        content()
                    }
                }
            )
        }
    }
}

@Preview
@Composable
private fun AppPreview() {
    App {
        HomeScreen(
            state = HomeScreenUIState(
                date = "2024-04-26",
                registers = sampleRegisters.filter { d -> d.date == "2024-04-26" }
            )
        )
    }
}