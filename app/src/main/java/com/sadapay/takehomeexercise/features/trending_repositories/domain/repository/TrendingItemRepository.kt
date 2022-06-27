package com.sadapay.takehomeexercise.features.trending_repositories.domain.repository

import com.sadapay.takehomeexercise.features.trending_repositories.data.utils.NetworkApiCallStatus
import com.sadapay.takehomeexercise.features.trending_repositories.domain.models.TrendingItem
import kotlinx.coroutines.flow.Flow

interface TrendingItemRepository {
    /**
     * Network
     * */
    suspend fun getTrendingRepositoriesFromRemote(): Flow<NetworkApiCallStatus<List<TrendingItem>>>

    /**
     * Local - RoomDB
     * */
    fun getTrendingRepositoriesFromLocal(): Flow<List<TrendingItem>>
    suspend fun deleteRepositoryByID(id: Int)
    suspend fun deleteAllRepositories()
    suspend fun saveAllRepositories(list: List<TrendingItem>)
    suspend fun saveRepository(trendingItem: TrendingItem)
}