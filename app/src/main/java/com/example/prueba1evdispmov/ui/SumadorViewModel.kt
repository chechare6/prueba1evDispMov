package com.example.prueba1evdispmov.ui

import androidx.lifecycle.ViewModel

class SumadorViewModel : ViewModel() {
    private val operaciones = mutableListOf<String>()

    fun addOperacion(operacion: String) {
        operaciones.add(operacion)
    }

    fun getOperaciones(): List<String> {
        return operaciones.toList()
    }
}