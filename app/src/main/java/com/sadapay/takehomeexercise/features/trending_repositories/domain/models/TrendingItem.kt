package com.sadapay.takehomeexercise.features.trending_repositories.domain.models

data class TrendingItem(
    private val itemID: Int,
    private val repositoryStars: Int,
    private val forksCount: Int,

    private val isItemExpanded: Boolean,
    private val avatarURL: String,
    private val itemHeading: String,
    private val itemDescription: String,
    private val repositoryLanguage: String,

    /**
     * Extras: maybe used in future implementations
     * */
    private val userURLPage: String,
    private val repositoryURLPage: String,
)
