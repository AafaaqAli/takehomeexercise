package com.sadapay.takehomeexercise.features.trending_repositories.domain.usecases

import com.sadapay.takehomeexercise.features.trending_repositories.domain.repository.TrendingItemRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class DeleteTrendingRepositoryByIdUseCase(
    private val repository: TrendingItemRepository
) {
    /**
     * Delete Trending Repository by id
     * */
    fun execute(id: Int){
        CoroutineScope(Dispatchers.IO + Job()).launch {
            repository.deleteRepositoryByID(id)
        }
    }
}