package com.sadapay.takehomeexercise.presentation.fragments.network_error_fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.sadapay.takehomeexercise.R
import com.sadapay.takehomeexercise.databinding.FragmentNetworkErrorBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NetworkErrorFragment: Fragment() {

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


        /*
        * TODO: For testing only
        * TODO: REMOVE AFTER TESTING
        * */
        binding.buttonRetry.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_networkErrorFragment_to_mainScreenFragment);
        }
    }


    /**
     * Garbage collection: when fragment is de-attached or destroyed, there is no need for binding,
     * */
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}