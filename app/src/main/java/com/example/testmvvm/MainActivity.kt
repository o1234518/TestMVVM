package com.example.testmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.testmvvm.databinding.ActivityMainBinding
import com.example.testmvvm.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    lateinit private var binding: ActivityMainBinding
    private var viewModel: MainViewModel = MainViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel
    }
}