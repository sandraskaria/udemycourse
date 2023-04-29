package com.example.livedata.student

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StudentViewModel(val student: Student): ViewModel() {

    private var studentData = MutableLiveData<Student>()

    val studentLiveData: LiveData<Student>
        get() = studentData

    init {
        studentData.value = student
    }

   fun calculatePercent(acquiredMark: Int) {
       if (acquiredMark <= 500) {
           val percent = acquiredMark * 100 / 500
           studentData.value?.percent = percent
           studentData.value = student
       }
   }

}