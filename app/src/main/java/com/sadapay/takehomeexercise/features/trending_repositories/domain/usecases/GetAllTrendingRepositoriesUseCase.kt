package com.sadapay.takehomeexercise.features.trending_repositories.domain.usecases

import com.sadapay.takehomeexercise.features.trending_repositories.data.utils.NetworkApiCallStatus
import com.sadapay.takehomeexercise.features.trending_repositories.domain.models.TrendingItem
import com.sadapay.takehomeexercise.features.trending_repositories.domain.repository.TrendingItemRepository
import kotlinx.coroutines.flow.Flow

class GetAllTrendingRepositoriesUseCase(
    private val repository: TrendingItemRepository
) {
    /**
     * Make a mechanism to find if sync is needed if not than get from local database
     * */
    suspend fun execute(): Flow<NetworkApiCallStatus<List<TrendingItem>>> = repository.getTrendingRepositoriesFromRemote()
}