package com.sadapay.takehomeexercise.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sadapay.takehomeexercise.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    /**
     * View Binding
     * */
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}