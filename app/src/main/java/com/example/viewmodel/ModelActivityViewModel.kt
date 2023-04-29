package com.example.viewmodel

import androidx.lifecycle.ViewModel

class ModelActivityViewModel(val startValue: Int): ViewModel() {
    private var count = 0

    init {
        count = startValue
    }

    fun doAddition(number: Int) {
       // count = number?.plus(count) ?: 0
        count += number
    }

    fun getUpdatedNumber(): Int {
        return count
    }
}