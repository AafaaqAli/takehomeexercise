package com.sadapay.takehomeexercise.features.trending_repositories.data.data_sources.repository

import com.sadapay.takehomeexercise.features.trending_repositories.data.data_sources.local.TrendingRepositoryDao
import com.sadapay.takehomeexercise.features.trending_repositories.data.data_sources.network.TrendingApiNetworkDataSource
import com.sadapay.takehomeexercise.features.trending_repositories.domain.models.TrendingItem
import com.sadapay.takehomeexercise.features.trending_repositories.domain.repository.TrendingItemRepository
import kotlinx.coroutines.flow.Flow

class TrendingItemRepositoryImp(
    private val trendingApiNetworkDataSource: TrendingApiNetworkDataSource,
    private val trendingRepositoryDao: TrendingRepositoryDao
) : TrendingItemRepository {

    override suspend fun getTrendingRepositoriesFromRemote(): Flow<List<TrendingItem>> =
        trendingApiNetworkDataSource.getTrendingRepositories()

    override fun getTrendingRepositoriesFromLocal(): Flow<List<TrendingItem>> =
        trendingRepositoryDao.getTrendingRepositories()

    override suspend fun deleteRepositoryByID(id: Int) {
        trendingRepositoryDao.deleteTrendingRepositoryByID(id)
    }

    override suspend fun deleteAllRepositories() {
        trendingRepositoryDao.deleteAllTrendingRepositories()
    }

    override suspend fun saveAllRepositories(list: List<TrendingItem>) {
        trendingRepositoryDao.insertAllRepositoryItem(list)
    }

    override suspend fun saveRepository(trendingItem: TrendingItem) {
       trendingRepositoryDao.addTrendingRepositoryItem(trendingItem)
    }
}