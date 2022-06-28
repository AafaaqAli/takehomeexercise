package com.sadapay.takehomeexercise.features.trending_repositories.domain.usecases

data class UseCases(
    val getAllRemoteTrendingRepositories: GetAllRemoteTrendingRepositoriesUseCase,
    val deleteAllTrendingRepositories: DeleteAllTrendingRepositoriesUseCase,
    val getAllTrendingRepositories: GetAllTrendingRepositoriesUseCase,
    val insertTrendingRepositories: InsertTrendingRepositoryUseCase,
    val insertAllTrendingRepositoryUseCase: InsertAllTrendingRepositoryUseCase,
)