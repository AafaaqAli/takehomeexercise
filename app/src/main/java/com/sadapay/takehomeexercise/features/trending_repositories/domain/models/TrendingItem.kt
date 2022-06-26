package com.sadapay.takehomeexercise.features.trending_repositories.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TrendingItem(

    @PrimaryKey
    var itemID: Int,
    var repositoryStars: Int,
    var forksCount: Int,

    var isItemExpanded: Boolean,
    var avatarURL: String,
    var itemHeadingUserName: String,
    var itemSubHeadingRepositoryName: String,
    var itemDescription: String,
    var repositoryLanguage: String,

    /**
     * Extras: maybe used in future implementations
     * */
    var userURLPage: String,
    var repositoryURLPage: String,
)
