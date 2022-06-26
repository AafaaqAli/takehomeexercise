package com.sadapay.takehomeexercise.features.trending_repositories.presentation.fragments.main_screen_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.snackbar.Snackbar
import com.sadapay.takehomeexercise.R
import com.sadapay.takehomeexercise.databinding.FragmentMainScreenBinding
import com.sadapay.takehomeexercise.features.trending_repositories.presentation.fragments.main_screen_fragment.ui_states.MainFragmentUIState
import com.sadapay.takehomeexercise.features.trending_repositories.presentation.fragments.main_screen_fragment.ui_states.MainFragmentUIStateHelper
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.flow.collect


@AndroidEntryPoint
class MainScreenFragment : Fragment() {
    /**
     * ViewModel
     * */
    private lateinit var viewModel: MainScreenViewModel

    /**
     * View Binding
     * */
    private var _binding: FragmentMainScreenBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainScreenBinding.inflate(inflater, container, false)
        /**
         * RecyclerView
         * */
        return binding.root
    }

    /**
     * Only init ViewModel when after view is created
     * */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[MainScreenViewModel::class.java]
        binding.lifecycleOwner = this

        /**
         * Observing Ui state
         * */
        getStates()

        /**
         * RecyclerView
         * */
        binding.viewModel = this.viewModel
        viewModel.populateRecyclerView()
    }

    /**
     * Garbage collection: when fragment is de-attached or destroyed, there is no need for binding,
     * */
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /**
     * Observer UI States from ViewModel
     * */
    @OptIn(DelicateCoroutinesApi::class)
    private fun getStates() {
        var isFragmentLoaded = false
        /**
         * Should Start listening the state onResume
         * */
        lifecycleScope.launchWhenStarted {
            viewModel.mainScreenStateFlow.collect {
                when (it) {
                    is MainFragmentUIState.NoInternet -> {
                        /**
                         * Items loading got failed due to some error
                         * */
                        binding.mainScreenLayoutSwipeToRefresh.isRefreshing = false
                        if (!isFragmentLoaded) {
                            NavHostFragment.findNavController(this@MainScreenFragment)
                                .navigate(R.id.action_mainScreenFragment_to_networkErrorFragment)
                            isFragmentLoaded = true
                        }
                    }

                    is MainFragmentUIState.LoadingError -> {
                        Snackbar.make(binding.root, it.errorMessage, Snackbar.LENGTH_LONG).show()
                        /**
                         * Items loading got failed due to some error
                         * */
                    }

                    is MainFragmentUIState.Loading -> {
                        /**
                         * Items currently loading in recyclerview
                         * */
                        MainFragmentUIStateHelper.disableComponentsOnLoading(binding)
                    }

                    is MainFragmentUIState.LoadSuccess -> {
                        /**
                         * Successful Loading of items
                         * */
                        MainFragmentUIStateHelper.enableComponentsAfterLoading(binding)
                    }

                    is MainFragmentUIState.Empty -> {
                        /**
                         * Initial State where view-model is just got bound
                         * */
                    }
                }
            }
        }
    }
}