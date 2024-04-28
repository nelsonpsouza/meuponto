package br.com.nelsonps.meuponto.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.nelsonps.meuponto.ui.screens.RegisterFormScreen
import br.com.nelsonps.meuponto.ui.theme.MeuPontoTheme
import br.com.nelsonps.meuponto.ui.viewmodels.RegisterFormViewModel
import br.com.nelsonps.meuponto.ui.viewmodels.RegisterFormViewModelFactory

class RegisterFormActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            MeuPontoTheme {
                Surface {
                    //val viewModel by viewModels<RegisterFormViewModel>()
                    val viewModel: RegisterFormViewModel =
                        viewModel(factory = RegisterFormViewModelFactory("2024-04-27"))
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