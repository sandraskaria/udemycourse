package com.example.livedata.student

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.databinding.R
import com.example.databinding.databinding.ActivityStudentBinding

class StudentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStudentBinding
    private lateinit var viewModel: StudentViewModel
    private lateinit var viewModelFactory: StudentViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_student)

        val student = Student("SAndra", 400)

        viewModelFactory = StudentViewModelFactory(student)

        viewModel = ViewModelProvider(this, viewModelFactory).get(StudentViewModel::class.java)

        viewModel.studentLiveData.observe(this, Observer {
            binding.editTextTextPersonName.setText(it.name)
            binding.yourMark.setText(it.total.toString())
            val text = "${it.name} scored ${it.percent}% on board exam!!"
            binding.totalMark.text = text
        })

        binding.calculatePercent.setOnClickListener {
            with(student) {
                name = binding.editTextTextPersonName.text.toString()
                total = binding.yourMark.text.toString().toInt()
            }
            viewModel.calculatePercent(binding.yourMark.text.toString().toInt())
        }

    }
}