package com.sadapay.takehomeexercise.features.trending_repositories.data.data_sources.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sadapay.app_utils.constants.AppConstants
import com.sadapay.takehomeexercise.features.trending_repositories.domain.models.TrendingItem
import kotlinx.coroutines.flow.Flow

@Dao
interface TrendingRepositoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addTrendingRepositoryItem(trendingItem: TrendingItem)

    @Query("SELECT * FROM ${AppConstants.TABLE_NAME}")
    fun getTrendingRepositories(): Flow<List<TrendingItem>>

    @Query("DELETE FROM ${AppConstants.TABLE_NAME}")
    suspend fun deleteAllTrendingRepositories()

    @Query("DELETE FROM ${AppConstants.TABLE_NAME} WHERE itemID =:id")
    suspend fun deleteNoteByID(id: Int)
}