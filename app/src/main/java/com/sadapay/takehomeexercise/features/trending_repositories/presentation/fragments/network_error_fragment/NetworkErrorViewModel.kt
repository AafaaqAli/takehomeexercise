package com.sadapay.takehomeexercise.features.trending_repositories.presentation.fragments.network_error_fragment

import android.app.Application
import androidx.lifecycle.ViewModel
import com.sadapay.app_utils.utils.network.NetworkUtils
import com.sadapay.app_utils.utils.network.NetworkUtils.isNetworkConnected
import com.sadapay.takehomeexercise.R
import com.sadapay.takehomeexercise.features.trending_repositories.presentation.fragments.network_error_fragment.ui_states.NetworkErrorFragmentUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import javax.inject.Inject

@HiltViewModel
class NetworkErrorViewModel @Inject constructor(
    private val application: Application
) : ViewModel() {
    private val _state =
        MutableStateFlow<NetworkErrorFragmentUIState>(NetworkErrorFragmentUIState.Empty)
    val networkErrorFragmentStateFlow: SharedFlow<NetworkErrorFragmentUIState> = _state

    fun onRetryClicked() {
        System.out.println("NetworkErrorClicked")
        if (application.isNetworkConnected() && NetworkUtils.internetIsConnected()) {
            _state.value = NetworkErrorFragmentUIState.NetworkAvailable
        } else {
            _state.value =
                NetworkErrorFragmentUIState.NoInternet(application.getString(R.string.ERROR_MESSAGE_NETWORK_CHECK))
        }
    }

    fun isNetworkAvailable() =
        application.isNetworkConnected() && NetworkUtils.internetIsConnected()

}

