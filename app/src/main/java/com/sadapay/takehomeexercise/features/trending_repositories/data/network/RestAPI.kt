package com.sadapay.takehomeexercise.features.trending_repositories.data.network

import com.sadapay.takehomeexercise.features.trending_repositories.domain.models.TrendingRepositoriesResponse

interface RestAPI {
    fun getTrendingRepositories(response: ArrayList<TrendingRepositoriesResponse>)
}