package com.sadapay.takehomeexercise.features.trending_repositories.domain.usecases

import com.sadapay.takehomeexercise.features.trending_repositories.domain.models.TrendingItem
import com.sadapay.takehomeexercise.features.trending_repositories.domain.repository.TrendingItemRepository
import kotlinx.coroutines.*

class InsertTrendingRepositoryUseCase(
    private val repository: TrendingItemRepository

) {
    /**
     * Insert Into DB
     * */
    fun execute(trendingItem: TrendingItem){
        CoroutineScope(Dispatchers.IO + Job()).launch {
            repository.saveRepository(trendingItem)
        }
    }
}