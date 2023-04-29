package com.example.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LiveDataActivityViewModel(val startValue: Int): ViewModel() {
    private var count = MutableLiveData<Int>()
    val countLiveData: LiveData<Int>
        get() {
            println("SANDRA LVM ${count.value}")
            return count
        }

    init {
        count.value = startValue
    }

    fun doAddition(number: Int) {
        count.value = count.value?.plus(number)
    }
}