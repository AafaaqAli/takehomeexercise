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
    const val DATABASE_NAME: String = "trending_repositories"
    const val TABLE_NAME: String = "trending_item"
    const val DATABASE_VERSION: Int = 1

    /**
     * Data store keys
     */
    const val IS_APP_FIRST_RUN = "is_first_run_store_key"
    const val LAST_SYNC_DATE_TIME = "trending_repositories_last_sync_time_store_key"

    /**
     * Language File Constants
     * */
    const val LANGUAGE_COLOR_INFO_FILE_LOCATION: String = "github_language_color_code.json"

    /**
     * Sync time to see if time has been spent or not
     * */
    const val SYNC_TIME_IN_HOURS: Int = 24
    const val ONE_SECONDS_IN_MILLS: Int = 1000
    const val HOUR: Int = 60
    const val MINUTE: Int = 60
    const val DAY: Int = 24
}