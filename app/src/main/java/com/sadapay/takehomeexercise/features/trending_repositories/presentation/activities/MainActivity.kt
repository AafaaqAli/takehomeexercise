package com.sadapay.takehomeexercise.features.trending_repositories.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sadapay.app_utils.utils.network.ConnectionLiveData
import com.sadapay.takehomeexercise.databinding.ActivityMainBinding
import com.sadapay.takehomeexercise.features.trending_repositories.presentation.animation_utils.NetworkRibbonAnimationHelper
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var connectionLiveData: ConnectionLiveData

    /**
     * View Binding
     * */
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    @OptIn(DelicateCoroutinesApi::class)
    override fun onStart() {
        super.onStart()

        connectionLiveData = ConnectionLiveData(this)
        connectionLiveData.observe(this) { isNetworkAvailable ->
            NetworkRibbonAnimationHelper.animateRibbon(binding, isNetworkAvailable)
        }
    }
}