package com.sadapay.takehomeexercise.features.trending_repositories.presentation.fragments.main_screen_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.sadapay.takehomeexercise.R
import com.sadapay.takehomeexercise.databinding.FragmentMainScreenBinding
import com.sadapay.takehomeexercise.features.trending_repositories.presentation.fragments.main_screen_fragment.ui_states.MainFragmentUIState
import dagger.hilt.android.AndroidEntryPoint
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
        binding.recyclerViewModel = this.viewModel
        viewModel.populateRecyclerView()

        /*
       * TODO: For testing only
       * TODO: REMOVE AFTER TESTING
       * */
        binding.mainScreenLayoutSwipeToRefresh.setOnRefreshListener {
            binding.mainScreenLayoutSwipeToRefresh.isRefreshing = false
            Navigation.findNavController(view)
                .navigate(R.id.action_mainScreenFragment_to_networkErrorFragment);
        }
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
    private fun getStates() {
        /**
         * Should Start listening the state onResume
         * */
        lifecycleScope.launchWhenStarted {
            viewModel.mainScreenStateFlow.collect() {
                when (it) {
                    is MainFragmentUIState.NoInternet -> {
                        Toast.makeText(context, it.networkError, Toast.LENGTH_SHORT).show()
                        /**
                         * Items loading got failed due to some error
                         * */
                    }

                    is MainFragmentUIState.LoadingError -> {
                        Toast.makeText(context, it.errorMessage, Toast.LENGTH_SHORT).show()
                        /**
                         * Items loading got failed due to some error
                         * */
                    }

                    is MainFragmentUIState.Loading -> {
                        /**
                         * Items currently loading in recyclerview
                         * */
                        binding.shimmerLayoutMain.shimmerLayout.startShimmer()
                    }

                    is MainFragmentUIState.LoadSuccess -> {
                        /**
                         * Successful Loading of items
                         * */
                        binding.shimmerLayoutMain.shimmerLayout.stopShimmer()
                        binding.shimmerLayoutMain.shimmerLayout.visibility = View.GONE
                        binding.recyclerViewTrendingRepos.visibility = View.VISIBLE

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