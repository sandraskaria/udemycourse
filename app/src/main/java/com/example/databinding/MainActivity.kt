package com.example.databinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.databinding.databinding.ContentMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ContentMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.content_main)
        setContentView(binding.root)

        binding.student = Student("Asha", "ashasam@gmail.com")

        displayGreeting()

    }

    fun displayGreeting() {
        binding.apply {
            binding.showText.setText("Show Message")
            nextButton.setOnClickListener {
                binding.showText.setText("Hello Gorgeous")
            }

//            studentName.setText(student.name)
//            studentEmail.setText(student.email)
        }
    }

}