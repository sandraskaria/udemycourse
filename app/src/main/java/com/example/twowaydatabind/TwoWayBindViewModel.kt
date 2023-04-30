package com.example.twowaydatabind

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TwoWayBindViewModel: ViewModel() {

    var userName = MutableLiveData<String>()

    init {
        userName.value = "Anna"
    }

}