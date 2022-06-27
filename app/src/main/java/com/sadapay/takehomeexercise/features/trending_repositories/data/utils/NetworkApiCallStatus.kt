package com.sadapay.takehomeexercise.features.trending_repositories.data.utils

sealed class NetworkApiCallStatus<T>(
    val data: T? = null,
    val message: String? = null
) {
    class SUCCESS<T>(data: T) : NetworkApiCallStatus<T>(data)
    class ERROR<T>(message: String?, data: T? = null) : NetworkApiCallStatus<T>(data, message)
}
