package com.example.twowaydatabind

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.databinding.R
import com.example.databinding.databinding.ActivityTwoWayBindBinding

class TwoWayBindActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTwoWayBindBinding
    private lateinit var viewModel: TwoWayBindViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_two_way_bind)
        viewModel = ViewModelProvider(this).get(TwoWayBindViewModel::class.java)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

    }
}