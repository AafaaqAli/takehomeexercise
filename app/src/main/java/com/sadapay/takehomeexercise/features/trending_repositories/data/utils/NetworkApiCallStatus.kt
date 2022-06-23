package com.sadapay.takehomeexercise.features.trending_repositories.data.utils

sealed class NetworkApiCallStatus {
    object SUCCESS : NetworkApiCallStatus()
    object ERROR : NetworkApiCallStatus()
    object LOADING : NetworkApiCallStatus()
}
