package br.com.alura.aluvery.sampledata

import br.com.nelsonps.meuponto.model.Register

val sampleRegisters: List<Register> = listOf(
    Register(hour = "08:00"),
    Register(hour = "12:00", comments = "Esquecimento"),
    Register(hour = "13:00"),
    Register(hour = "17:00")
)
