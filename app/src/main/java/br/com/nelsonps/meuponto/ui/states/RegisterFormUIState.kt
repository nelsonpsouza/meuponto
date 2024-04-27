package br.com.nelsonps.meuponto.ui.states

data class RegisterFormUIState(
    val day: String = "",
    val hour: String = "",
    val comment: String = "",
    val onDayChange: (String) -> Unit = {},
    val onHourChange: (String) -> Unit = {},
    val onCommentChange: (String) -> Unit = {}
)