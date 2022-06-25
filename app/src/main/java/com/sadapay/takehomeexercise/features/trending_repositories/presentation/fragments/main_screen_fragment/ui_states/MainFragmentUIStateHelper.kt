package com.sadapay.takehomeexercise.features.trending_repositories.presentation.fragments.main_screen_fragment.ui_states

import android.view.View
import com.sadapay.takehomeexercise.databinding.FragmentMainScreenBinding

object MainFragmentUIStateHelper {

    /**
     * Manages view when Recycler View is getting loaded
     * */
    fun disableComponentsOnLoading(binding: FragmentMainScreenBinding) {
        binding.mainScreenLayoutSwipeToRefresh.isActivated = false
        binding.mainScreenLayoutSwipeToRefresh.isEnabled = false
        binding.shimmerLayoutMain.shimmerLayout.startShimmer()
        binding.shimmerLayoutMain.shimmerLayout.visibility = View.VISIBLE
    }

    /**
     * Manages view when Recycler View loaded
     * */
    fun enableComponentsAfterLoading(binding: FragmentMainScreenBinding) {
        binding.mainScreenLayoutSwipeToRefresh.isActivated = true
        binding.mainScreenLayoutSwipeToRefresh.isRefreshing = false
        binding.mainScreenLayoutSwipeToRefresh.isEnabled = true
        binding.shimmerLayoutMain.shimmerLayout.stopShimmer()
        binding.shimmerLayoutMain.shimmerLayout.visibility = View.GONE
        binding.recyclerViewTrendingRepos.visibility = View.VISIBLE
    }
}