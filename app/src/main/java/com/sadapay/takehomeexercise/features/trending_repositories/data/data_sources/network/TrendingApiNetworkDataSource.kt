package com.sadapay.takehomeexercise.features.trending_repositories.data.data_sources.network

import com.sadapay.takehomeexercise.features.trending_repositories.domain.models.Item
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TrendingApiNetworkDataSource @Inject constructor(
    val trendingApiService: TrendingRepositoryAPIService,
) {

    fun getTrendingRepositories(): Flow<Item> {
        runBlocking {
            launch(Dispatchers.IO + SupervisorJob()) {
                trendingApiService.getTrendingRepositories().apply {
                    if (this.incompleteResults == false) {
                        /**
                         * result is complete
                         * */
                        this.items.forEach {
                            /**
                             * Use Multithreading for each item parsing and saving
                             * */
                        }
                    } else {
                       /**
                        * response is not complete and should not be used
                        * */
                    }
                }
            }
        }
        return flow { }
    }
}