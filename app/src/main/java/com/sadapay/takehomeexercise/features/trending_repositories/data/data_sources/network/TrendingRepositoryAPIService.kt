package com.sadapay.takehomeexercise.features.trending_repositories.data.data_sources.network

import com.sadapay.app_utils.constants.AppConstants
import com.sadapay.takehomeexercise.features.trending_repositories.domain.models.TrendingRepositoriesResponse
import retrofit2.Response
import retrofit2.http.GET

interface TrendingRepositoryAPIService {
    @GET(AppConstants.RELATIVE_URL)
    suspend fun getTrendingRepositories(): Response<TrendingRepositoriesResponse>
}