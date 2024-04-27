package br.com.nelsonps.meuponto.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.nelsonps.meuponto.R
import br.com.nelsonps.meuponto.model.Register

@Composable
fun HourItem(
    register: Register,
    modifier: Modifier = Modifier,
) {
    Row (modifier = modifier){
        Image(
            painter = painterResource(id = R.drawable.outline_arrow_circle_right_24),
            contentDescription = "",
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(
                text = register.hour,
                fontSize = 16.sp
            )
            Text(
                text = register.comment,
                fontSize = 10.sp,
            )
        }
    }
}

@Preview
@Composable
fun HoraItemPreview() {
    HourItem(
        register = Register(
            day = "24/04/2024",
            hour = "10:00",
            comment = "Esquecimento",
        ),
        modifier = Modifier.padding(16.dp),
    )
}