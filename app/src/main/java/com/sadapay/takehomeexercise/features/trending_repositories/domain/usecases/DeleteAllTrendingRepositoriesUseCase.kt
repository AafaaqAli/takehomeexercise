package com.sadapay.takehomeexercise.features.trending_repositories.domain.usecases

import com.sadapay.takehomeexercise.features.trending_repositories.domain.repository.TrendingItemRepository
import kotlinx.coroutines.*

class DeleteAllTrendingRepositoriesUseCase(
    private val repository: TrendingItemRepository
) {
    /**
     * Delete All Trending repositories cache from db
     * */
    fun execute() {
        CoroutineScope(Dispatchers.IO + Job()).launch {
            repository.deleteAllRepositories()
        }
    }
}