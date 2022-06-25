package com.sadapay.takehomeexercise.features.trending_repositories.data.data_sources.repository

import com.sadapay.takehomeexercise.features.trending_repositories.data.data_sources.local.TrendingRepositoryDao
import com.sadapay.takehomeexercise.features.trending_repositories.data.data_sources.network.TrendingApiNetworkDataSource
import com.sadapay.takehomeexercise.features.trending_repositories.domain.models.TrendingItem
import com.sadapay.takehomeexercise.features.trending_repositories.domain.repository.TrendingItemRepository
import kotlinx.coroutines.flow.Flow

class TrendingItemRepositoryImp(
    private val trendingApiNetworkDataSource: TrendingApiNetworkDataSource,
    private val trendingRepositoryDao: TrendingRepositoryDao
): TrendingItemRepository {

    override suspend fun getTrendingRepositoriesFromRemote(): Flow<List<TrendingItem>> {
        TODO("Not yet implemented")
    }

    override fun getTrendingRepositoriesFromLocal(): Flow<List<TrendingItem>> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteRepositoryByID(id: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteAllRepositories() {
        TODO("Not yet implemented")
    }
}