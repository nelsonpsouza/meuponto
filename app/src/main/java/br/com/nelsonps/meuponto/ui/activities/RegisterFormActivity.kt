package br.com.nelsonps.meuponto.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Surface
import br.com.nelsonps.meuponto.ui.screens.RegisterFormScreen
import br.com.nelsonps.meuponto.ui.theme.MeuPontoTheme
import br.com.nelsonps.meuponto.ui.viewmodels.RegisterFormViewModel

class RegisterFormActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            MeuPontoTheme {
                Surface {
                    val viewModel by viewModels<RegisterFormViewModel>()
                    RegisterFormScreen(
                        viewModel = viewModel,
                        onSaveClick = {
                            finish()
                        }
                    )
                }
            }
        }
    }
}