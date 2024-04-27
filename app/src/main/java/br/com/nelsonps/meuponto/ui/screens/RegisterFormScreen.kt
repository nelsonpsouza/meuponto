package br.com.nelsonps.meuponto.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.nelsonps.meuponto.ui.states.RegisterFormUIState
import br.com.nelsonps.meuponto.ui.theme.MeuPontoTheme
import br.com.nelsonps.meuponto.ui.viewmodels.RegisterFormViewModel

@Composable
fun RegisterFormScreen(
    viewModel: RegisterFormViewModel,
    onSaveClick: () -> Unit = {}
){
    val state by viewModel.uiState.collectAsState()
    RegisterFormScreen(
        state = state,
        onSaveClick = {
            viewModel.save()
            onSaveClick()
        }
    )
}
@Composable
fun RegisterFormScreen(
    state: RegisterFormUIState = RegisterFormUIState(),
    onSaveClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Spacer(modifier = Modifier)
        Text(
            text = "Registro de ponto",
            modifier = Modifier.fillMaxWidth(),
            fontSize = 28.sp,
        )
        Text(
            text = state.day,
            modifier = Modifier.fillMaxWidth(),
            fontSize = 28.sp,
        )
        TextField(
            value = state.hour,
            onValueChange = state.onHourChange,
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Horário")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next,
            ),
        )
        TextField(
            value = state.comment,
            onValueChange = state.onCommentChange,
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Comentário")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next,
            ),
        )
        Button(
            onClick = onSaveClick,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(text = "Salvar")
        }
        Spacer(modifier = Modifier)
    }
}

@Preview
@Composable
private fun RegisterFormScreenPreview() {
    MeuPontoTheme {
        Surface {
            RegisterFormScreen(
                    RegisterFormUIState(
                    day = "24/08/2024",
                    hour = "10:00",
                    comment = "Esquecimento",
                )
            )
        }
    }
}