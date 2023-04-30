package com.example.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.databinding.R
import com.example.databinding.databinding.ActivityDataviewModelBinding
import com.example.databinding.databinding.ActivityViewModelBinding

class ViewModelDataBindActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDataviewModelBinding
    private lateinit var viewModel: ViewModelDataBindViewModel
    private lateinit var viewModelFactory: ViewModelDataBindViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_dataview_model)

        viewModelFactory = ViewModelDataBindViewModelFactory(100)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ViewModelDataBindViewModel::class.java)
        binding.myViewModel = viewModel

        viewModel.startValue = 0
        viewModel.countVal.observe(this, Observer {
            binding.countText.text = it.toString()
        })


        /*binding.counterButton.setOnClickListener {
            val numberToAdd = binding.editTextNumber.text.toString()

            if(numberToAdd.isNotBlank()) {
                viewModel.doAddition(numberToAdd.toInt())

                binding.countText.text = viewModel.getUpdatedNumber().toString()
                binding.editTextNumber.text.clear()
            }
        }*/
    }
}