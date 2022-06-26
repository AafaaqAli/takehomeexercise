package com.sadapay.app_utils.animation_utils

import android.animation.ObjectAnimator
import android.view.View
import com.sadapay.takehomeexercise.databinding.ActivityMainBinding
import kotlinx.coroutines.*

object NetworkRibbonAnimationHelper {

    @OptIn(DelicateCoroutinesApi::class)
    fun animateRibbon(binding: ActivityMainBinding, isNetworkAvailable: Boolean) {
        if (isNetworkAvailable) {
            binding.apply {
                showRibbon(this, isNetworkAvailable)
            }

            GlobalScope.launch(Dispatchers.Main) {
                delay(4000)
                binding.networkRibbon.textViewConnectivityAvailable.visibility = View.GONE
                hideRibbon(binding)
            }

        } else {
            /**
             * Hide ribbon
             * */
            binding.apply {
                showRibbon(this, isNetworkAvailable)
            }
        }
    }

    private fun hideRibbon(binding: ActivityMainBinding) {
        binding.networkRibbon.relativeLayoutRibbonNoNetwork.visibility = View.GONE
        binding.networkRibbon.textViewConnectivityAvailable.visibility = View.GONE
        binding.networkRibbon.textViewNoConnectivity.visibility = View.GONE

        binding.navHostFragment.apply {

            ObjectAnimator.ofFloat(
                this,
                View.TRANSLATION_Y,
                binding.networkRibbon.relativeLayoutRibbonNoNetwork.height.toFloat(),
                0f
            ).apply {
                duration = 200
                start()
            }
        }

        binding.networkRibbon.relativeLayoutRibbonNoNetwork.apply {
            ObjectAnimator.ofFloat(
                this,
                View.TRANSLATION_Y,
                binding.networkRibbon.relativeLayoutRibbonNoNetwork.height.toFloat(),
                0f

            ).apply {
                duration = 200
                start()
            }
        }
    }

    private fun showRibbon(binding: ActivityMainBinding, isNetworkAvailable: Boolean) {
        if (isNetworkAvailable) {
            binding.networkRibbon.textViewNoConnectivity.visibility = View.GONE
            binding.networkRibbon.textViewConnectivityAvailable.visibility = View.VISIBLE
        } else {
            binding.networkRibbon.textViewConnectivityAvailable.visibility = View.GONE
            binding.networkRibbon.textViewNoConnectivity.visibility = View.VISIBLE
        }
        binding.networkRibbon.relativeLayoutRibbonNoNetwork.visibility = View.VISIBLE

        binding.networkRibbon.relativeLayoutRibbonNoNetwork.apply {
            ObjectAnimator.ofFloat(
                this,
                View.TRANSLATION_Y,
                0f,
                2f
            ).apply {
                duration = 200
                start()
            }
        }

        binding.navHostFragment.apply {
            ObjectAnimator.ofFloat(
                this,
                View.TRANSLATION_Y,
                0f,
                2f
            ).apply {
                duration = 200
                start()
            }
        }
    }
}