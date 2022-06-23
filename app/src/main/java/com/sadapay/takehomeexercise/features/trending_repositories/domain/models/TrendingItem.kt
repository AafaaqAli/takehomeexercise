package com.sadapay.takehomeexercise.features.trending_repositories.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TrendingItem(

    @PrimaryKey
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
