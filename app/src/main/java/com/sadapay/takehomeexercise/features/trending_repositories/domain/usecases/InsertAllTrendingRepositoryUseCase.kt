package com.sadapay.takehomeexercise.features.trending_repositories.domain.usecases

import com.sadapay.takehomeexercise.features.trending_repositories.domain.models.TrendingItem
import com.sadapay.takehomeexercise.features.trending_repositories.domain.repository.TrendingItemRepository
import kotlinx.coroutines.*

class InsertAllTrendingRepositoryUseCase(
    private val repository: TrendingItemRepository

) {
    /**
     * Insert all Into DB
     * */
    @OptIn(DelicateCoroutinesApi::class)
    fun execute(list: List<TrendingItem>){
        CoroutineScope(Dispatchers.IO + Job()).launch {
            repository.saveAllRepositories(list)
        }
    }
}