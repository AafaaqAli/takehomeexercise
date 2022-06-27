package com.sadapay.takehomeexercise.features.trending_repositories.data.data_sources.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sadapay.app_utils.constants.AppConstants
import com.sadapay.takehomeexercise.features.trending_repositories.domain.models.TrendingItem

@Dao
interface TrendingRepositoryDao {
    /*@Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addTrendingRepositoryItem(trendingItem: TrendingItem)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllRepositoryItem(list: List<TrendingItem>)

    @Query("SELECT * FROM ${AppConstants.TABLE_NAME}")
    fun getTrendingRepositories(): List<TrendingItem>

    @Query("DELETE FROM ${AppConstants.TABLE_NAME}")
    suspend fun deleteAllTrendingRepositories()

    @Query("DELETE FROM ${AppConstants.TABLE_NAME} WHERE itemID IN=:id")
    suspend fun deleteTrendingRepositoryByID(id: Int)*/
}