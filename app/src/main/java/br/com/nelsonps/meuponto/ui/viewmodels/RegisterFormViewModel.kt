package br.com.nelsonps.meuponto.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import br.com.nelsonps.meuponto.dao.RegisterDao
import br.com.nelsonps.meuponto.model.Register
import br.com.nelsonps.meuponto.ui.states.RegisterFormUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


private const val TAG: String = "RegisterFormViewModel"
class RegisterFormViewModel(date: String): ViewModel() {
    private val dao = RegisterDao()

    private val _uiState: MutableStateFlow<RegisterFormUIState> = MutableStateFlow(
        RegisterFormUIState(date = date)
    )
    val uiState get() = _uiState.asStateFlow()

    init {
        _uiState.update { currentState ->
            currentState.copy(
                onDateChange = {
                    _uiState.value = _uiState.value.copy(
                        date = it
                    )
                },
                onHourChange = {
                    _uiState.value = _uiState.value.copy(
                        hour = it
                    )
                },
                onCommentChange = {
                    _uiState.value = _uiState.value.copy(
                        comment = it
                    )
                },
            )
        }
    }
    fun save() {
        _uiState.value.run {
            val register = Register(
                date = date,
                hour = hour,
                comment = comment
            )
            Log.i(TAG, "save: register = $register")
            dao.save(register)
        }
    }
}