package br.com.nelsonps.meuponto.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.nelsonps.meuponto.dao.RegisterDao
import br.com.nelsonps.meuponto.model.Register

@Composable
fun RegisterFormScreen(
    day: String = "",
    hour: String = "",
    comment: String = "",
    onSaveClick: () -> Unit = {}
) {
    val h = rememberSaveable {
        mutableStateOf(hour)
    }
    val c = rememberSaveable {
        mutableStateOf(comment)
    }
    val dao = RegisterDao()

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
            text = day,
            modifier = Modifier.fillMaxWidth(),
            fontSize = 28.sp,
        )
        TextField(
            value = h.value,
            onValueChange = { newHour -> h.value = newHour },
        )
        TextField(
            value = c.value,
            onValueChange = { newComment -> c.value = newComment },
        )
        Button(
            onClick = {
                val register = Register (
                    day = day,
                    hour = h.value,
                    comments = c.value
                )
                dao.save(register)
                onSaveClick()
            },
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
    RegisterFormScreen(
        day = "24/08/2024",
        hour = "10:00",
        comment = "Esquecimento",
    )
}