package br.com.nelsonps.meuponto.ui.states

data class RegisterFormUIState(
    val date: String = "",
    val hour: String = "",
    val comment: String = "",
    val onDateChange: (String) -> Unit = {},
    val onHourChange: (String) -> Unit = {},
    val onCommentChange: (String) -> Unit = {}
)