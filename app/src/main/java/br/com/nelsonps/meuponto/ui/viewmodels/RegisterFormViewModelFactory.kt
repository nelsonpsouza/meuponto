package br.com.nelsonps.meuponto.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class RegisterFormViewModelFactory(private val date: String) :
    ViewModelProvider.NewInstanceFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>):
                T = RegisterFormViewModel(date) as T
}