package com.sadapay.takehomeexercise.features.trending_repositories.domain.usecases

data class UseCases(
    val deleteAllTrendingRepositories: DeleteAllTrendingRepositoriesUseCase,
    val getAllTrendingRepositories: GetAllTrendingRepositoriesUseCase,
    val insertTrendingRepositories: InsertTrendingRepositoryUseCase
)