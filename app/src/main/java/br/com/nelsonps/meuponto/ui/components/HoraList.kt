package br.com.nelsonps.meuponto.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HoraList() {
    Column {
        val modifier = Modifier
            .padding(8.dp)
        HoraItem(hora = "08:00", modifier)
        HoraItem(hora = "12:00", modifier)
        HoraItem(hora = "13:00", modifier)
        HoraItem(hora = "17:00", modifier)
    }
}

@Preview
@Composable
fun HoraListPreview() {
    HoraList()
}