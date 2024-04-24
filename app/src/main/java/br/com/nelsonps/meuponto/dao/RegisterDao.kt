package br.com.nelsonps.meuponto.dao

import br.com.nelsonps.meuponto.model.Register
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class RegisterDao {

    companion object {
        private val registers = MutableStateFlow<List<Register>>(emptyList())
    }

    fun registers(): StateFlow<List<Register>> = registers.asStateFlow()

    fun save(register: Register) {
        registers.value += register
    }
}