package com.example.baguette.rxbindingkotlinsample

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.baguette.rxbindingkotlinsample.databinding.ActivityMainBinding
import com.jakewharton.rxbinding.widget.RxTextView

class MainActivity : AppCompatActivity() {

    val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModel(RxTextView.textChanges(binding.editText))
        binding.viewModel = viewModel
    }
}
