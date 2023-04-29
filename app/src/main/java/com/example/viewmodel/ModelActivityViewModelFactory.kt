package com.example.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ModelActivityViewModelFactory(val startValue: Int): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ModelActivityViewModel::class.java)) {
            return ModelActivityViewModel(startValue) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}