package com.sadapay.takehomeexercise.features.trending_repositories.presentation.fragments.network_error_fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import com.sadapay.takehomeexercise.R
import com.sadapay.takehomeexercise.databinding.FragmentNetworkErrorBinding
import com.sadapay.takehomeexercise.features.trending_repositories.presentation.fragments.network_error_fragment.ui_states.NetworkErrorFragmentUIState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class NetworkErrorFragment : Fragment() {

    /**
     * ViewModel
     * */
    private lateinit var viewModel: NetworkErrorViewModel

    /**
     * View Binding
     * */
    private var _binding: FragmentNetworkErrorBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNetworkErrorBinding.inflate(inflater, container, false)
        return binding.root
    }

    /**
     * Only init ViewModel when after view is created
     * */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[NetworkErrorViewModel::class.java]
        binding.lifecycleOwner = this

        /**
         * Observing Ui state
         * */
        binding.viewModel = this.viewModel

        /**
         * Ui state management
         * */
        getStates()
        manageBackPress()
    }


    /**
     * Garbage collection: when fragment is de-attached or destroyed, there is no need for binding,
     * */
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun getStates() {
        /**
         * Should Start listening the state onResume
         * */
        lifecycleScope.launchWhenStarted {
            viewModel.networkErrorFragmentStateFlow.collect {
                when (it) {
                    is NetworkErrorFragmentUIState.Empty -> {
                        /**
                         * Initial State where view-model is just got bound
                         * */
                    }

                    is NetworkErrorFragmentUIState.NoInternet -> {
                        /**
                         * Items loading got failed due to some error
                         * */
                    }

                    is NetworkErrorFragmentUIState.Retrying -> {
                        /**
                         * Items currently loading in recyclerview
                         * */

                    }

                    is NetworkErrorFragmentUIState.NetworkAvailable -> {
                        /**
                         * Network Available now can navigate to Main Fragment for loading
                         * */
                        if (viewModel.isNetworkAvailable()) {
                            NavHostFragment.findNavController(this@NetworkErrorFragment).apply {
                                this.navigate(R.id.action_networkErrorFragment_to_mainScreenFragment)
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     *
     * Disable back-press un till internet is available
     * */
    private fun manageBackPress() {
        requireActivity().onBackPressedDispatcher.addCallback(this) {

        }
    }
}