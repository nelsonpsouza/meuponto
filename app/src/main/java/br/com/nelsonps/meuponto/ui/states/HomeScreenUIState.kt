package br.com.nelsonps.meuponto.ui.states

import br.com.nelsonps.meuponto.model.Register

data class HomeScreenUIState (
    val day: String = "",
    val registers: List<Register> = emptyList(),
    val onListChange: () -> Unit = {}
)