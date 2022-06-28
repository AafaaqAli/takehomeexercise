package com.sadapay.takehomeexercise.di

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler
import androidx.datastore.preferences.SharedPreferencesMigration
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStoreFile
import androidx.room.Room
import com.sadapay.app_utils.constants.AppConstants
import com.sadapay.app_utils.utils.preference_datastore.PreferenceDataStoreOperations
import com.sadapay.takehomeexercise.features.trending_repositories.data.data_sources.local.TrendingRepositoryDao
import com.sadapay.takehomeexercise.features.trending_repositories.data.data_sources.local.TrendingRepositoryDatabase
import com.sadapay.takehomeexercise.features.trending_repositories.data.data_sources.network.TrendingApiNetworkDataSource
import com.sadapay.takehomeexercise.features.trending_repositories.data.data_sources.repository.TrendingItemRepositoryImp
import com.sadapay.takehomeexercise.features.trending_repositories.domain.repository.TrendingItemRepository
import com.sadapay.takehomeexercise.features.trending_repositories.domain.usecases.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun providePreferencesDataStore(@ApplicationContext appContext: Context): DataStore<Preferences> {
        return PreferenceDataStoreFactory.create(
            corruptionHandler = ReplaceFileCorruptionHandler(
                /**
                 * If data-store is corrupted or framework is failing to read from the file
                 * then fallback mechanism is to clear the corrupted data.
                 * */
                produceNewData = { emptyPreferences() }
            ),
            /**
             * If there is a need of data-migration than this method will provide a migration
             * mechanism which will return list of APP_PREFERENCES_NAME files in key-pair see [APP_PREFERENCES_NAME]
             * */
            migrations = listOf(
                SharedPreferencesMigration(
                    appContext,
                    AppConstants.APP_PREFERENCES_NAME
                )
            ),

            /**
             * Scope defines the the thread on which the data manipulation from dataStore should start
             * SupervisorJob() creates a Thread for other child threads which are fail independent of
             * parent job
             * */
            scope = CoroutineScope(Dispatchers.IO + SupervisorJob()),
            produceFile = { appContext.preferencesDataStoreFile(AppConstants.APP_PREFERENCES_NAME) }
        )
    }

    @Provides
    @Singleton
    fun providesDataStoreOperations(preferenceDataStore: DataStore<Preferences>,) = PreferenceDataStoreOperations(preferenceDataStore)


    @Provides
    @Singleton
    fun providesSharedPreference(@ApplicationContext appContext: Context) = appContext.getSharedPreferences(AppConstants.APP_PREFERENCES_NAME, Context.MODE_PRIVATE)


    /**
     * Room Specific dependencies
     * */
    @Provides
    @Singleton
    fun providesTrendingRepositoryDatabase(application: Application): TrendingRepositoryDatabase {
        return Room.databaseBuilder(
            application,
            TrendingRepositoryDatabase::class.java,
            AppConstants.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun providesTrendingRepositoryDao(trendingRepositoryDatabase: TrendingRepositoryDatabase): TrendingRepositoryDao =
        trendingRepositoryDatabase.trendingRepositoryDao

    @Provides
    @Singleton
    fun providesTrendingRepositoryNetworkDatasource(
        trendingApiNetworkDataSource: TrendingApiNetworkDataSource,
        trendingRepositoryDao: TrendingRepositoryDao
    ): TrendingItemRepository =
        TrendingItemRepositoryImp(trendingApiNetworkDataSource, trendingRepositoryDao)

    @Provides
    @Singleton
    fun providesTrendingRepositoryUseCases(repository: TrendingItemRepository): UseCases {
        return UseCases(
            GetAllRemoteTrendingRepositoriesUseCase(repository),
            DeleteAllTrendingRepositoriesUseCase(repository),
            GetAllTrendingRepositoriesUseCase(repository),
            InsertTrendingRepositoryUseCase(repository),
            InsertAllTrendingRepositoryUseCase(repository)
        )
    }
}