package br.com.nelsonps.meuponto.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.alura.aluvery.sampledata.sampleRegisters
import br.com.nelsonps.meuponto.model.Register

@Composable
fun HourList(
    modifier: Modifier = Modifier,
    day: String = "",
    registers: List<Register> = emptyList(),
) {
    Column(modifier = modifier) {
        Text(
            text = day,
            modifier = Modifier.padding(
                start = 16.dp,
                end = 16.dp
            ),
            fontSize = 20.sp,
            fontWeight = FontWeight(400)
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(registers) { reg ->
                HourItem(
                    register = reg,
                    modifier = Modifier.padding(8.dp),
                )
            }
        }
    }
}

@Preview
@Composable
fun HourListPreview() {
    HourList(
        modifier = Modifier.padding(8.dp),
        day = "24/04/2024",
        registers = sampleRegisters,
    )
}