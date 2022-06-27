package com.sadapay.takehomeexercise.features.trending_repositories.domain.models

import com.google.gson.annotations.SerializedName

data class LanguageColorItem(
    @SerializedName("language_colors" ) var languageColors : ArrayList<LanguageColors> = arrayListOf()

)
