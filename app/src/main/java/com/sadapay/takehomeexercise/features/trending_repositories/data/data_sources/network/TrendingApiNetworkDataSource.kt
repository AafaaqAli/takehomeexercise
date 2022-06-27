package com.sadapay.takehomeexercise.features.trending_repositories.data.data_sources.network

import com.sadapay.takehomeexercise.features.trending_repositories.data.utils.NetworkApiCallStatus
import com.sadapay.takehomeexercise.features.trending_repositories.domain.models.TrendingItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TrendingApiNetworkDataSource @Inject constructor(
    val trendingApiService: TrendingRepositoryAPIService,
) {
    suspend fun getTrendingRepositories(): Flow<NetworkApiCallStatus<List<TrendingItem>>> {
        val trendingItemList: ArrayList<TrendingItem> = arrayListOf()
        val response = trendingApiService.getTrendingRepositories()
        if (response.isSuccessful && !response.body()?.incompleteResults!!) {
            response.body()?.items?.forEach { responseItem ->
                trendingItemList.add(
                    TrendingItem(
                        responseItem.id!!,
                        responseItem.stargazersCount!!,
                        responseItem.forksCount!!,
                        false,
                        responseItem.owner?.avatarUrl!!,
                        responseItem.owner?.login!!,
                        responseItem.name!!,
                        responseItem.description!!,
                        responseItem.language.toString(),
                        responseItem.owner?.url!!,
                        responseItem.owner?.reposUrl!!,
                    )
                )
            }
            return flow {
                emit(NetworkApiCallStatus.SUCCESS(trendingItemList.toList()))
            }

        } else {
            return flow {
                emit(NetworkApiCallStatus.ERROR(response.errorBody()?.toString()))
            }
        }

    }
}