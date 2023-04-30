package com.example.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelDataBindViewModelFactory(val startValue: Int): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ViewModelDataBindViewModel::class.java)) {
            return ViewModelDataBindViewModel(startValue) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}