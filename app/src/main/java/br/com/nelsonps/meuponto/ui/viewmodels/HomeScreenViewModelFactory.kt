package br.com.nelsonps.meuponto.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class HomeScreenViewModelFactory(private val date: String) :
    ViewModelProvider.NewInstanceFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>):
                T = HomeScreenViewModel(date) as T
}