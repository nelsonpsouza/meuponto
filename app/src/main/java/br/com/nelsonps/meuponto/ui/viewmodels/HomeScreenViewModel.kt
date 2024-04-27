package br.com.nelsonps.meuponto.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.nelsonps.meuponto.dao.RegisterDao
import br.com.nelsonps.meuponto.ui.states.HomeScreenUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeScreenViewModel: ViewModel() {
    private val dao = RegisterDao()

    private val _uiState: MutableStateFlow<HomeScreenUIState> = MutableStateFlow(
        HomeScreenUIState()
    )
    val uiState get() = _uiState.asStateFlow()

    init {
        _uiState.update { currentState ->
            currentState.copy(
                onListChange = {
                    _uiState.value = _uiState.value.copy(
                        registers = dao.registers().value
                    )
                }
            )
        }

        viewModelScope.launch {
            dao.registers().collect { registers ->
                _uiState.value = _uiState.value.copy(
                    registers = registers
                )
            }
        }
    }
}