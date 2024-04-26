package br.com.nelsonps.meuponto.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.alura.aluvery.sampledata.sampleRegisters
import br.com.nelsonps.meuponto.ui.components.HourList
import br.com.nelsonps.meuponto.ui.states.HomeScreenUIState
import br.com.nelsonps.meuponto.ui.theme.MeuPontoTheme
import br.com.nelsonps.meuponto.ui.viewmodels.HomeScreenViewModel

@Composable
fun HomeScreen(
    date: String,
    viewModel: HomeScreenViewModel
) {
    val state by viewModel.uiState.collectAsState()
    HomeScreen(date = date, state = state)
}

@Composable
fun HomeScreen(
    date: String = "",
    state: HomeScreenUIState = HomeScreenUIState(date)
) {
    HourList(
        modifier = Modifier.padding(8.dp),
        date = state.date,
        registers = state.registers,
    )
}

@Preview
@Composable
fun HomeScreenPreview() {
    MeuPontoTheme {
        Surface {
            HomeScreen(
                state = HomeScreenUIState(
                    date = "2024-04-26",
                    registers = sampleRegisters.filter { d -> d.date == "2024-04-26" }
                )
            )
        }
    }
}