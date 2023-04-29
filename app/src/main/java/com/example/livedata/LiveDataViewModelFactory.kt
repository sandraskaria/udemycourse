package com.example.livedata

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class LiveDataViewModelFactory(val startValue: Int): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LiveDataActivityViewModel::class.java)) {
            return LiveDataActivityViewModel(startValue) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}