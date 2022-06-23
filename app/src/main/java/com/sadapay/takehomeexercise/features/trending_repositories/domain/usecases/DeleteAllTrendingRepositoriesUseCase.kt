package com.sadapay.takehomeexercise.features.trending_repositories.domain.usecases

import com.sadapay.takehomeexercise.features.trending_repositories.domain.repository.TrendingItemRepository

class DeleteAllTrendingRepositoriesUseCase(
    private val repository: TrendingItemRepository
) {
    /**
     * Delete All Trending repositories cache from db
     * */
}