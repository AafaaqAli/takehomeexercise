package com.sadapay.takehomeexercise.features.trending_repositories.domain.usecases

import com.sadapay.takehomeexercise.features.trending_repositories.domain.repository.TrendingItemRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class GetAllTrendingRepositoriesUseCase(
    private val repository: TrendingItemRepository
) {
    /**
     * Make a mechanism to find if sync is needed if not than get from local database
     * */
    fun execute(){
        CoroutineScope(Dispatchers.IO + Job()).launch {
            repository.getTrendingRepositoriesFromRemote()
        }
    }
}