package com.example.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.databinding.R
import com.example.databinding.databinding.ActivityViewModelBinding

class ViewModelActivity : AppCompatActivity() {
    private lateinit var binding: ActivityViewModelBinding
    private lateinit var viewModel: ModelActivityViewModel
    private lateinit var viewModelFactory: ModelActivityViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_model)

        viewModelFactory = ModelActivityViewModelFactory(100)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ModelActivityViewModel::class.java)

        //viewModel = ViewModelProvider(this).get(ModelActivityViewModel::class.java)

        binding.countText.text = viewModel.getUpdatedNumber().toString()

        binding.counterButton.setOnClickListener {
            val numberToAdd = binding.editTextNumber.text.toString()

            if(numberToAdd.isNotBlank()) {
                viewModel.doAddition(numberToAdd.toInt())

                binding.countText.text = viewModel.getUpdatedNumber().toString()
                binding.editTextNumber.text.clear()
            }
        }
    }
}