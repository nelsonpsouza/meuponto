package br.com.nelsonps.meuponto.ui.viewmodels

import androidx.lifecycle.ViewModel
import br.com.nelsonps.meuponto.dao.RegisterDao
import br.com.nelsonps.meuponto.model.Register
import br.com.nelsonps.meuponto.ui.states.RegisterFormUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RegisterFormViewModel: ViewModel() {
    private val dao = RegisterDao()

    private val _uiState: MutableStateFlow<RegisterFormUIState> = MutableStateFlow(
        RegisterFormUIState()
    )
    val uiState get() = _uiState.asStateFlow()

    init {
        _uiState.update { currentState ->
            currentState.copy(
                onDayChange = {
                    _uiState.value = _uiState.value.copy(
                        day = it
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
                day = day,
                hour = hour,
                comment = comment
            )
            dao.save(register)
        }
    }
}