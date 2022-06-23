package com.sadapay.takehomeexercise.features.trending_repositories.data.data_sources.network

import com.sadapay.takehomeexercise.features.trending_repositories.domain.models.TrendingRepositoriesResponse

interface TrendingRepositoryAPIService {
    suspend fun getTrendingRepositories(): TrendingRepositoriesResponse
}