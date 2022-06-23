package com.sadapay.takehomeexercise.features.trending_repositories.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.sadapay.app_utils.utils.ConnectionLiveData
import com.sadapay.takehomeexercise.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import java.util.*
import kotlin.concurrent.timerTask

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
            if (isNetworkAvailable) {
                binding.textViewConnectivityAvailable.visibility = View.VISIBLE
                binding.textViewNoConnectivity.visibility = View.GONE

                Timer().schedule(timerTask {
                    GlobalScope.launch(Dispatchers.Main) {
                        binding.textViewConnectivityAvailable.visibility = View.GONE
                    }
                }, 3000)
            } else {
                binding.textViewConnectivityAvailable.visibility = View.GONE
                binding.textViewNoConnectivity.visibility = View.VISIBLE
            }
        }
    }
}