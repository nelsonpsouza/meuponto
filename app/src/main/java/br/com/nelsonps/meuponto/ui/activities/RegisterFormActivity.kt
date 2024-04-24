package br.com.nelsonps.meuponto.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import br.com.nelsonps.meuponto.ui.screens.RegisterFormScreen
import br.com.nelsonps.meuponto.ui.theme.MeuPontoTheme

class RegisterFormActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            MeuPontoTheme {
                Surface {
                    RegisterFormScreen(
                        day = "24/04/2024",
                        onSaveClick = {
                            finish()
                        }
                    )
                }
            }
        }
    }
}