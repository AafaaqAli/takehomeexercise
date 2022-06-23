package com.sadapay.app_utils.constants

object AppConstants {
    /**
     * Data store Key-pairs (PREFERENCE KEYS)
     * */
    const val APP_PREFERENCES_NAME: String = "sada_pay_preferences"

    /**
     * Database/Table name & Version
     * */
    const val DATABASE_NAME: String = "trending_repositories.db"
    const val TABLE_NAME: String = "trending_repositories"
    const val DATABASE_VERSION: Int = 1

    /**
     * TODO: FIX BASE URL, INTRODUCE RELATIVE URL IN RETROFIT API CALL
     * */
    const val BASE_URL: String = "https://api.github.com/search/repositories?q=language=+sort:stars"

}