package com.sadapay.takehomeexercise.features.trending_repositories.presentation.fragments.main_screen_fragment

import android.app.Application
import android.graphics.Color
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.DiffUtil
import com.sadapay.app_utils.utils.network.NetworkUtils
import com.sadapay.app_utils.utils.network.NetworkUtils.isNetworkConnected
import com.sadapay.takehomeexercise.R
import com.sadapay.takehomeexercise.features.trending_repositories.data.utils.NetworkApiCallStatus
import com.sadapay.takehomeexercise.features.trending_repositories.domain.models.TrendingItem
import com.sadapay.takehomeexercise.features.trending_repositories.domain.usecases.UseCases
import com.sadapay.takehomeexercise.features.trending_repositories.domain.utils.LanguageColorParser
import com.sadapay.takehomeexercise.features.trending_repositories.presentation.fragments.main_screen_fragment.adapters.TrendingItemsDiffUtil
import com.sadapay.takehomeexercise.features.trending_repositories.presentation.fragments.main_screen_fragment.adapters.TrendingRepositoriesAdapter
import com.sadapay.takehomeexercise.features.trending_repositories.presentation.fragments.main_screen_fragment.ui_states.MainFragmentUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val application: Application,
    private val useCases: UseCases
) : ViewModel() {
    private val _state = MutableStateFlow<MainFragmentUIState>(MainFragmentUIState.Empty)

    val mainScreenStateFlow: SharedFlow<MainFragmentUIState> = _state

    private var oldTrendingItems: List<TrendingItem> = arrayListOf()
    private var newTrendingItems: List<TrendingItem> = arrayListOf()

    private val recyclerViewAdapter: TrendingRepositoriesAdapter = TrendingRepositoriesAdapter()

    init {
        recyclerViewAdapter.setRecyclerViewViewModel(this)
    }

    fun fetchTrendingRepositories() {
        /**
         * if(networkAvailable){
         * if (db == null || db.entries.size == 0) {
         *  populateData(doAPICall.onDataCollected.parseData()).also{
         *      globalScope.launch(Dispachers.IO){
         *          db.saveTrendingData()
         *      }
         *   }
         * }else{
         *      if(shouldSync && lastSyncTimeDifference >= 24Hours){
         *          populateData(doAPICall.onDataCollected.parseData()).also{
         *               globalScope.launch(Dispachers.IO){
         *                  db.saveTrendingData()
         *               }
         *            }
         *      }
         * }
         *
         * }else{
         *  NavigateUserToNetworkErrorFragment & Show Network Ribbon
         * }
         *
         * */

        if (application.isNetworkConnected() && NetworkUtils.internetIsConnected()) {
            /**
             * Check sync status & get data accordingly
             * */
            viewModelScope.launch {
                useCases.getAllTrendingRepositories
                    .execute().onStart {
                        /**
                         * Set state to loading e.g start shimmer/refresh layout through MainFragmentUIStateHelper
                         * */
                        _state.value =
                            MainFragmentUIState.Loading
                    }.catch { exception ->
                        /**
                         * there's some error show the toast
                         * */
                        _state.value =
                            MainFragmentUIState.LoadingError("Exception: " + exception.message.toString())
                    }.collect { response ->
                        when (response) {
                            is NetworkApiCallStatus.SUCCESS -> {
                                /**
                                 * Response is successful, show items, and save them in room
                                 * */
                                _state.value =
                                    MainFragmentUIState.LoadSuccess
                                setTrendingItemList(response.data!!)
                            }

                            is NetworkApiCallStatus.ERROR -> {
                                /**
                                 * Response is unsuccessful, show items if already stored else take user to network error fragment
                                 * */
                                _state.value =
                                    MainFragmentUIState.LoadingError("ERROR: " + response.message.toString())
                            }
                        }
                    }
            }
        } else {
            _state.value =
                MainFragmentUIState.NoInternet(application.getString(R.string.ERROR_MESSAGE_NETWORK_CHECK))

        }
    }

    fun getLanguageColor(position: Int): String {
        return LanguageColorParser.langColor(application, getLanguage(position))
    }

    private fun setTrendingItemList(newTrendingItems: List<TrendingItem>) {
        val diffUtil = TrendingItemsDiffUtil(oldTrendingItems, newTrendingItems)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        this.oldTrendingItems = newTrendingItems
        this.newTrendingItems = newTrendingItems

        diffResult.dispatchUpdatesTo(recyclerViewAdapter)
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    fun setIsExpanded(position: Int, expansion: Boolean) {
        newTrendingItems[position].isItemExpanded = expansion
        recyclerViewAdapter.notifyItemChanged(position)
    }

    fun getRecyclerViewAdapter() = recyclerViewAdapter
    fun getTrendingItems(): List<TrendingItem?> = this.oldTrendingItems
    fun getIsExpanded(position: Int) = oldTrendingItems[position].isItemExpanded
    fun getTitleUserName(position: Int) = oldTrendingItems[position].itemHeadingUserName
    fun getRepositoryName(position: Int) =
        oldTrendingItems[position].itemSubHeadingRepositoryName

    fun getDescription(position: Int) = oldTrendingItems[position].itemDescription
    fun getGetAvatarLink(position: Int) = oldTrendingItems[position].avatarURL
    fun getLanguage(position: Int) = oldTrendingItems[position].repositoryLanguage
    fun getStars(position: Int) = oldTrendingItems[position].repositoryStars.toString()
}