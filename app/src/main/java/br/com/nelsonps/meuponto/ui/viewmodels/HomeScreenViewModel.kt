package br.com.nelsonps.meuponto.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.nelsonps.meuponto.dao.RegisterDao
import br.com.nelsonps.meuponto.model.Register
import br.com.nelsonps.meuponto.ui.states.HomeScreenUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeScreenViewModel(date: String): ViewModel() {
    private val dao = RegisterDao()

    private val _uiState: MutableStateFlow<HomeScreenUIState> = MutableStateFlow(
        HomeScreenUIState(date = date)
    )
    val uiState get() = _uiState.asStateFlow()

    init {
        _uiState.update { currentState ->
            currentState.copy(
                onDateChange = {
                    _uiState.value = _uiState.value.copy(
                        date = it,
                        registers = filteredRegisters(it)
                    )
                }
            )
        }

        viewModelScope.launch {
            dao.registers().collect { registers ->
                _uiState.value = _uiState.value.copy(
                    date = _uiState.value.date,
                    registers = filteredRegisters(_uiState.value.date)
                )
            }
        }
    }

    private fun filteredRegisters(date: String): List<Register> =
        if (date.isNotBlank()) {
            dao.registers().value.filter(dateEqualsTo(date))
        } else emptyList()

    private fun dateEqualsTo(date: String) = { register: Register ->
        register.date.equals(date)
    }
}