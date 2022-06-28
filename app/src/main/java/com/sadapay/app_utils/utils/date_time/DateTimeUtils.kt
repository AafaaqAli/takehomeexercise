package com.sadapay.app_utils.utils.date_time

import com.sadapay.app_utils.constants.AppConstants

fun Long.isSyncTime(lastUpdatedTime: Long): Boolean{
    val currentTime = (this / AppConstants.ONE_SECONDS_IN_MILLS) / (AppConstants.MINUTE) / (AppConstants.HOUR)
    val lastSyncTime =  (lastUpdatedTime / AppConstants.ONE_SECONDS_IN_MILLS) / (AppConstants.MINUTE) / (AppConstants.HOUR)
    return (lastSyncTime - currentTime) < AppConstants.HOUR
}