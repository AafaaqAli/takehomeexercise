package com.sadapay.takehomeexercise.features.trending_repositories.presentation.fragments.network_error_fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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

        /**
         * Observing Ui state
         * */
        getStates()
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
            viewModel.networkErrorFragmentStateFlow.collect() {
                when (it) {
                    is NetworkErrorFragmentUIState.NoInternet -> {
                        /**
                         * Items loading got failed due to some error
                         * */
                        Toast.makeText(context, it.networkError, Toast.LENGTH_SHORT).show()
                    }

                    is NetworkErrorFragmentUIState.Retry -> {
                        /**
                         * Items currently loading in recyclerview
                         * */
                    }


                    is NetworkErrorFragmentUIState.Empty -> {
                        /**
                         * Initial State where view-model is just got bound
                         * */
                    }

                    is NetworkErrorFragmentUIState.NetworkAvailable -> {
                        /**
                         * Network Available now can navigate to Main Fragment for loading
                         * */
                        NavHostFragment.findNavController(this@NetworkErrorFragment)
                            .navigate(R.id.action_networkErrorFragment_to_mainScreenFragment)
                    }
                }
            }
        }
    }
}