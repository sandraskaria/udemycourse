package com.example.twowaydatabind.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.databinding.R
import com.example.databinding.databinding.ActivityTwoWayAddBinding

class TwoWayAddActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTwoWayAddBinding
    private lateinit var viewModel: TwoWayAddViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_two_way_add)
        viewModel = ViewModelProvider(this).get(TwoWayAddViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

    }
}