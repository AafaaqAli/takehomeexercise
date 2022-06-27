package com.sadapay.takehomeexercise.features.trending_repositories.domain.models

import com.google.gson.annotations.SerializedName

data class LanguageColors(
    @SerializedName("name") var name: String? = null,
    @SerializedName("value") var value: String? = null
)