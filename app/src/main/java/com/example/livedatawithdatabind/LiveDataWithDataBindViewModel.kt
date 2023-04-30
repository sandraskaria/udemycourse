package com.example.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LiveDataWithDataBindViewModel(var startValue: Int): ViewModel() {
    private var count = MutableLiveData<Int>()
    val countVal : LiveData<Int>
        get() = count

    init {
        count.value = startValue
    }

    fun doAddition() {
        count.value = count.value?.plus(1)
    }

    fun getUpdatedNumber(): Int? {
        return count.value?.toInt()
    }
}