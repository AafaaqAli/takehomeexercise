package com.sadapay.takehomeexercise.features.trending_repositories.domain.utils

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sadapay.app_utils.constants.AppConstants.LANGUAGE_COLOR_INFO_FILE_LOCATION
import com.sadapay.takehomeexercise.features.trending_repositories.domain.models.LanguageColorItem


object LanguageColorParser {
    fun langColor(context: Context, langName: String): String {
        var color = ""
        context.assets.open(LANGUAGE_COLOR_INFO_FILE_LOCATION).bufferedReader().use {
            it.readText().run {
                val gson = Gson()
                val colorItem = object : TypeToken<LanguageColorItem>() {}.type
                val colorsList: LanguageColorItem = gson.fromJson(this, colorItem)
                colorsList.languageColors.forEach {
                    if (it.name.toString().trim().lowercase() == langName.trim().lowercase()) {
                        color = it.value!!
                    }
                }
            }
        }
        return if (color.isBlank() || color.isEmpty()) {
            "#3F51B5"
        } else {
            color

        }
    }
}