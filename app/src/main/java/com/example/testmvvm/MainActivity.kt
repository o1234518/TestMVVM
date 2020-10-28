package com.example.testmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.Observable
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.testmvvm.databinding.ActivityMainBinding
import com.example.testmvvm.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    lateinit private var binding: ActivityMainBinding
    private var viewModel: MainViewModel = MainViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.mData.observe(this, object: Observer<String> {
            override fun onChanged(data: String?) {
                binding.txtHelloWord.text = data
            }
        })

        viewModel.toastText.observe(this, object: Observer<String> {
            override fun onChanged(text: String?) {
                Toast.makeText(applicationContext, text, Toast.LENGTH_SHORT).show()
            }
        })
        binding.viewModel = viewModel
    }
}