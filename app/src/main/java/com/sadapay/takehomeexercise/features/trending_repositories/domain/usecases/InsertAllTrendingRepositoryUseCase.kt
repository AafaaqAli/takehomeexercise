package com.sadapay.takehomeexercise.features.trending_repositories.domain.usecases

import com.sadapay.takehomeexercise.features.trending_repositories.domain.models.TrendingItem
import com.sadapay.takehomeexercise.features.trending_repositories.domain.repository.TrendingItemRepository

class InsertAllTrendingRepositoryUseCase(
    private val repository: TrendingItemRepository

) {
    /**
     * Insert all Into DB
     * */
    fun execute(list: List<TrendingItem>){

    }
}