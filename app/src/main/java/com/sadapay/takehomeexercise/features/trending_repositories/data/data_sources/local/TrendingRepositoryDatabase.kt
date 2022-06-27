package com.sadapay.takehomeexercise.features.trending_repositories.data.data_sources.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sadapay.app_utils.constants.AppConstants
import com.sadapay.takehomeexercise.features.trending_repositories.domain.models.TrendingItem


@Database(
    entities = [TrendingItem::class],
    version = AppConstants.DATABASE_VERSION,
    exportSchema = false
)
abstract class TrendingRepositoryDatabase : RoomDatabase() {
    abstract val trendingRepositoryDao: TrendingRepositoryDao
}