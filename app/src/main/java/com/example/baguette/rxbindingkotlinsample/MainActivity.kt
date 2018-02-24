package com.example.baguette.rxbindingkotlinsample

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.baguette.rxbindingkotlinsample.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModel(com.jakewharton.rxbinding2.widget.RxTextView.textChanges(binding.editText))
        binding.viewModel = viewModel
    }
}
