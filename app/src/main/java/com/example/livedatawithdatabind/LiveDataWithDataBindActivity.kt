package com.example.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.databinding.R
import com.example.databinding.databinding.ActivityDataviewModelBinding
import com.example.databinding.databinding.ActivityLivedataviewModelBinding

class LiveDataWithDataBindActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLivedataviewModelBinding
    private lateinit var viewModel: LiveDataWithDataBindViewModel
    private lateinit var viewModelFactory: LiveDataWithDataBindViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_livedataview_model)

        viewModelFactory = LiveDataWithDataBindViewModelFactory(100)
        viewModel = ViewModelProvider(this, viewModelFactory).get(LiveDataWithDataBindViewModel::class.java)
        binding.lifecycleOwner = this
        binding.myViewModel = viewModel

        viewModel.startValue = 0

       /* viewModel.countVal.observe(this, Observer {
            binding.countText.text = it.toString()
        })*/

    }
}