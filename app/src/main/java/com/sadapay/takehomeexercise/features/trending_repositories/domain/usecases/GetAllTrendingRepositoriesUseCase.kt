package com.sadapay.takehomeexercise.features.trending_repositories.domain.usecases

import com.sadapay.takehomeexercise.features.trending_repositories.domain.repository.TrendingItemRepository

class GetAllTrendingRepositoriesUseCase(
    private val repository: TrendingItemRepository
) {
    /**
     * Make a mechanism to find if sync is needed if not than get from local database
     * */
}