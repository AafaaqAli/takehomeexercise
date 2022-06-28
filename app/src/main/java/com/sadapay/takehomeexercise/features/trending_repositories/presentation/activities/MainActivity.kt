package com.sadapay.takehomeexercise.features.trending_repositories.presentation.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.sadapay.app_utils.animation_utils.NetworkRibbonAnimationHelper
import com.sadapay.app_utils.utils.network.ConnectionLiveData
import com.sadapay.takehomeexercise.R
import com.sadapay.takehomeexercise.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.DelicateCoroutinesApi


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

        handleMenuClick()
    }

    private fun handleMenuClick() {
        binding.topAppBar.setOnMenuItemClickListener { menuItem ->
            if (menuItem.itemId == R.id.menu_item_switch_ui_mode) {
                Toast.makeText(this, "Under Progress...", Toast.LENGTH_SHORT).show()
                return@setOnMenuItemClickListener true
            } else {
                return@setOnMenuItemClickListener false
            }
        }
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