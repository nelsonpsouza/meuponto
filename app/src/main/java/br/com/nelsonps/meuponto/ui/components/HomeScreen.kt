package br.com.nelsonps.meuponto.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.nelsonps.meuponto.ui.theme.MeuPontoTheme

@Composable
fun HomeScreen() {
    MeuPontoTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            HoraList()
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}