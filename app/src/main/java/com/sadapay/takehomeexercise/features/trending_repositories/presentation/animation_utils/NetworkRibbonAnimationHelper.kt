package com.sadapay.takehomeexercise.features.trending_repositories.presentation.animation_utils

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
                delay(3000)
                binding.textViewConnectivityAvailable.visibility = View.GONE
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
        binding.relativeLayoutRibbonNoNetwork.visibility = View.GONE
        binding.textViewConnectivityAvailable.visibility = View.GONE
        binding.textViewNoConnectivity.visibility = View.GONE

        binding.navHostFragment.apply {

            ObjectAnimator.ofFloat(
                this,
                View.TRANSLATION_Y,
                binding.relativeLayoutRibbonNoNetwork.height.toFloat(),
                0f
            ).apply {
                duration = 200
                start()
            }
        }

        binding.relativeLayoutRibbonNoNetwork.apply {
            ObjectAnimator.ofFloat(
                this,
                View.TRANSLATION_Y,
                binding.relativeLayoutRibbonNoNetwork.height.toFloat(),
                0f

            ).apply {
                duration = 200
                start()
            }
        }
    }

    private fun showRibbon(binding: ActivityMainBinding, isNetworkAvailable: Boolean) {
        if(isNetworkAvailable){
            binding.textViewNoConnectivity.visibility = View.GONE
            binding.textViewConnectivityAvailable.visibility = View.VISIBLE
        }else{
            binding.textViewConnectivityAvailable.visibility = View.GONE
            binding.textViewNoConnectivity.visibility = View.VISIBLE
        }
        binding.relativeLayoutRibbonNoNetwork.visibility = View.VISIBLE

        binding.relativeLayoutRibbonNoNetwork.apply {
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