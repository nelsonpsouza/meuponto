package br.com.nelsonps.meuponto.model

data class Register(
    //provisoriamente, em desenvolvimento, guardarei o dia como atributo do registro
    //posteriormente, será migrado para a classe WorkShift
    val date: String = "",
    val hour: String = "",
    val comment: String = ""
)