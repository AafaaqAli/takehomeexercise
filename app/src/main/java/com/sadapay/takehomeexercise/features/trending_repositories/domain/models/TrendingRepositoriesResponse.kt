package com.sadapay.takehomeexercise.features.trending_repositories.domain.models

import com.google.gson.annotations.SerializedName

data class TrendingRepositoriesResponse(
    @SerializedName("total_count")
    var totalCount: Int? = null,

    @SerializedName("incomplete_results")
    var incompleteResults: Boolean? = null,

    @SerializedName("items")
    var items: ArrayList<Item> = arrayListOf()
)