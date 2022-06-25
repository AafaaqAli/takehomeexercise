package com.sadapay.takehomeexercise.features.trending_repositories.presentation.fragments.main_screen_fragment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sadapay.takehomeexercise.BR
import com.sadapay.takehomeexercise.R
import com.sadapay.takehomeexercise.databinding.LayoutItemTrendingRepositoryBinding
import com.sadapay.takehomeexercise.features.trending_repositories.presentation.fragments.main_screen_fragment.MainScreenViewModel

class TrendingRepositoriesAdapter(
): RecyclerView.Adapter<TrendingRepositoriesAdapter.ViewHolder>() {
    private lateinit var recyclerViewViewModel: MainScreenViewModel
    private lateinit var binding: LayoutItemTrendingRepositoryBinding

    fun setRecyclerViewViewModel(recyclerViewViewModel: MainScreenViewModel) {
        this.recyclerViewViewModel = recyclerViewViewModel
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.layout_item_trending_repository, parent, false)
        return ViewHolder(binding)
    }

   inner class ViewHolder(private val binding: LayoutItemTrendingRepositoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(mainFragmentViewModel: MainScreenViewModel?, position: Int?) {
            binding.setVariable(BR.recyclerViewModel, mainFragmentViewModel)
            binding.setVariable(BR.position, position)
            binding.executePendingBindings()
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(recyclerViewViewModel, position)
    }

    override fun getItemCount(): Int {
        return recyclerViewViewModel.getTrendingItems().size

    }
}