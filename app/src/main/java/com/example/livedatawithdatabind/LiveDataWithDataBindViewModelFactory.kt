package com.example.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class LiveDataWithDataBindViewModelFactory(val startValue: Int): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LiveDataWithDataBindViewModel::class.java)) {
            return LiveDataWithDataBindViewModel(startValue) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}