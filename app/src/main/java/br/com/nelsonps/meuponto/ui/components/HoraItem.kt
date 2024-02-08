package br.com.nelsonps.meuponto.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.nelsonps.meuponto.R

@Composable
fun HoraItem(
    hora: String,
    modifier: Modifier = Modifier,
) {
    Row (modifier = modifier){
        Image(
            painter = painterResource(id = R.drawable.outline_arrow_circle_right_24),
            contentDescription = "",
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = hora
        )
    }
}

@Preview
@Composable
fun HoraItemPreview() {
    val modifier = Modifier
        .padding(16.dp)
    HoraItem(hora = "10:00", modifier)
}