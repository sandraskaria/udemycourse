package com.example.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.databinding.R
import com.example.databinding.databinding.ActivityViewModelBinding

class LiveDataActivity : AppCompatActivity() {
    private lateinit var binding: ActivityViewModelBinding
    private lateinit var viewModel: LiveDataActivityViewModel
    private lateinit var viewModelFactory: LiveDataViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_model)

        viewModelFactory = LiveDataViewModelFactory(100)
        viewModel = ViewModelProvider(this, viewModelFactory).get(LiveDataActivityViewModel::class.java)

        viewModel.countLiveData.observe(this, Observer {
            binding.countText.text = it.toString()
            println("SANDRA LVA ${it}")
        })

        binding.counterButton.setOnClickListener {
            val numberToAdd = binding.editTextNumber.text.toString()

            if(numberToAdd.isNotBlank()) {
                viewModel.doAddition(numberToAdd.toInt())
                binding.editTextNumber.text.clear()
            }
        }
    }
}