package com.sadapay.takehomeexercise.features.trending_repositories.data.data_sources.network

import javax.inject.Inject

class TrendingApiNetworkDataSource @Inject constructor(
    val trendingApiService: TrendingRepositoryAPIService
) {
    /**
     * TODO: Call API here with proper threading. in co-routines
     * */
}