package com.example.twowaydatabind.sample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TwoWayAddViewModel: ViewModel() {
    private var totalNum = MutableLiveData<Int>()
    val total: LiveData<Int>
        get() = totalNum

    var editNum = MutableLiveData<String>()

    init {
        totalNum.value = 0
    }

    fun addition() {
        val editInt = editNum.value.toString().toInt()
        totalNum.value = totalNum.value?.plus(editInt)
    }
}