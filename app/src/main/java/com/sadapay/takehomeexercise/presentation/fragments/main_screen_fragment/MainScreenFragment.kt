package com.sadapay.takehomeexercise.presentation.fragments.main_screen_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
import com.sadapay.takehomeexercise.R
import com.sadapay.takehomeexercise.databinding.FragmentMainScreenBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainScreenFragment: Fragment() {
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
        return binding.root
    }

    /**
     * Only init ViewModel when after view is created
     * */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[MainScreenViewModel::class.java]


        /*
       * TODO: For testing only
       * TODO: REMOVE AFTER TESTING
       * */
        binding.mainScreenLayoutSwipeToRefresh.setOnRefreshListener {
            binding.mainScreenLayoutSwipeToRefresh.isRefreshing = false
            Navigation.findNavController(view).navigate(R.id.action_mainScreenFragment_to_networkErrorFragment);
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