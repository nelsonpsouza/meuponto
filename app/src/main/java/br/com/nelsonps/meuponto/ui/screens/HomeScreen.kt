package br.com.nelsonps.meuponto.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.alura.aluvery.sampledata.sampleHours
import br.com.nelsonps.meuponto.ui.components.HourList
import br.com.nelsonps.meuponto.ui.theme.MeuPontoTheme

@Composable
fun HomeScreen() {
    MeuPontoTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            HourList(
                day = "24/04/2024",
                hours = sampleHours,
                modifier = Modifier.padding(8.dp),
            )
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}