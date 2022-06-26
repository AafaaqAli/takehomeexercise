package com.sadapay.app_utils.constants

object AppConstants {
    /**
     * Data store Key-pairs (PREFERENCE KEYS)
     * */
    const val APP_PREFERENCES_NAME: String = "sada_pay_preferences"

    const val BASE_URL: String = "https://api.github.com/"
    const val RELATIVE_URL: String = "search/repositories?q=language=+sort:stars"

    /**
     * Database/Table name & Version
     * */
    const val DATABASE_NAME: String = "trending_repositories.db"
    const val TABLE_NAME: String = "trending_repositories"
    const val DATABASE_VERSION: Int = 1

    /**
     * Data store keys
     */
    const val LAST_SYNC_DATE_TIME = "trending_repositories_last_sync_time_store_key"
}