package br.com.nelsonps.meuponto.model

data class WorkShift(
    val date: String? = null,
    val registers: List<Register> = emptyList()
)