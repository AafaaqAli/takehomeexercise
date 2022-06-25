package com.sadapay.takehomeexercise.features.trending_repositories.presentation.fragments.main_screen_fragment.ui_states

sealed class MainFragmentUIState{
    data class NoInternet(val networkError: String) : MainFragmentUIState()
    data class LoadingError(val errorMessage: String) : MainFragmentUIState()
    object Loading : MainFragmentUIState()
    object LoadSuccess: MainFragmentUIState()
    object Empty : MainFragmentUIState()
}
