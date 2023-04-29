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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_model)
        viewModel = ViewModelProvider(this).get(ModelActivityViewModel::class.java)

        binding.countText.text = viewModel.getCurrentCount().toString()

        binding.counterButton.setOnClickListener {
            binding.countText.text = viewModel.getUpdatedCount().toString()
        }
    }
}