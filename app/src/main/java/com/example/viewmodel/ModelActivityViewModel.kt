package com.example.viewmodel

import androidx.lifecycle.ViewModel

class ModelActivityViewModel: ViewModel() {
    private var count = 0

    fun getCurrentCount(): Int {
        return count
    }

    fun getUpdatedCount(): Int {
        return ++count
    }
}