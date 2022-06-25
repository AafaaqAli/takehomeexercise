package com.sadapay.takehomeexercise.features.trending_repositories.presentation.fragments.network_error_fragment

import android.app.Application
import androidx.lifecycle.ViewModel
import com.sadapay.app_utils.utils.ConnectionLiveData
import com.sadapay.takehomeexercise.R
import com.sadapay.takehomeexercise.features.trending_repositories.presentation.fragments.network_error_fragment.ui_states.NetworkErrorFragmentUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class NetworkErrorViewModel @Inject constructor(
    private val application: Application
) : ViewModel() {
    private val connectionLiveData = ConnectionLiveData(application)
    private val _state = MutableStateFlow<NetworkErrorFragmentUIState>(NetworkErrorFragmentUIState.Empty)

    val networkErrorFragmentStateFlow: SharedFlow<NetworkErrorFragmentUIState> = _state

    fun onRetryClicked(){
        if (connectionLiveData.value == true) {
            _state.value = NetworkErrorFragmentUIState.NetworkAvailable
        }else{
            _state.value = NetworkErrorFragmentUIState.NoInternet(application.getString(R.string.ERROR_MESSAGE_NETWORK_CHECK))
        }
    }
}