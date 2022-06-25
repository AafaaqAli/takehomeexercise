package com.sadapay.takehomeexercise.features.trending_repositories.presentation.fragments.network_error_fragment.ui_states

sealed class NetworkErrorFragmentUIState{
    data class NoInternet(val networkError: String) : NetworkErrorFragmentUIState()
    object Empty : NetworkErrorFragmentUIState()
    object Retry: NetworkErrorFragmentUIState()
    object NetworkAvailable: NetworkErrorFragmentUIState()
}
