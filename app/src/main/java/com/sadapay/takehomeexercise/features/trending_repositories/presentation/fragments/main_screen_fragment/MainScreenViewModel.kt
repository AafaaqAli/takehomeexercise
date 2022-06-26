package com.sadapay.takehomeexercise.features.trending_repositories.presentation.fragments.main_screen_fragment

import android.app.Application
import androidx.lifecycle.ViewModel
import com.sadapay.app_utils.utils.NetworkUtils
import com.sadapay.app_utils.utils.NetworkUtils.isNetworkConnected
import com.sadapay.takehomeexercise.R
import com.sadapay.takehomeexercise.features.trending_repositories.domain.models.TrendingItem
import com.sadapay.takehomeexercise.features.trending_repositories.presentation.fragments.main_screen_fragment.adapters.TrendingRepositoriesAdapter
import com.sadapay.takehomeexercise.features.trending_repositories.presentation.fragments.main_screen_fragment.ui_states.MainFragmentUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val application: Application
) : ViewModel() {
    private val _state = MutableStateFlow<MainFragmentUIState>(MainFragmentUIState.Empty)

    val mainScreenStateFlow: SharedFlow<MainFragmentUIState> = _state

    private var trendingItems: List<TrendingItem> = ArrayList()
    private val recyclerViewAdapter: TrendingRepositoriesAdapter = TrendingRepositoriesAdapter()

    init {
        recyclerViewAdapter.setRecyclerViewViewModel(this)
    }

    @OptIn(DelicateCoroutinesApi::class)
    fun populateRecyclerView() = GlobalScope.launch {
        /**
         * TODO: Remove on implementing data sources, Mocking the loading state,
         * */
        _state.value = MainFragmentUIState.Loading
        /**
         * For now use notifyDataSetChanged but use diff-utils
         * */
        val arrayListOfItems: ArrayList<TrendingItem> = arrayListOf()
        arrayListOfItems.add(
            TrendingItem(
                1,
                500,
                20,
                false,
                "https://picsum.photos/200/300",
                "Item Heading",
                "Item Description",
                "Python",
                "https://picsum.photos/200/300",
                "https://picsum.photos/200/300"
            )
        )

        arrayListOfItems.add(
            TrendingItem(
                1,
                500,
                20,
                false,
                "https://picsum.photos/200/300",
                "Item Heading",
                "Item Description",
                "Python",
                "https://picsum.photos/200/300",
                "https://picsum.photos/200/300"
            )
        )

        arrayListOfItems.add(
            TrendingItem(
                2,
                500,
                20,
                false,
                "https://picsum.photos/200/300",
                "Item Heading",
                "Item Description",
                "Python",
                "https://picsum.photos/200/300",
                "https://picsum.photos/200/300"
            )
        )

        arrayListOfItems.add(
            TrendingItem(
                3,
                500,
                20,
                false,
                "https://picsum.photos/200/300",
                "Item Heading",
                "Item Description",
                "Python",
                "https://picsum.photos/200/300",
                "https://picsum.photos/200/300"
            )
        )

        arrayListOfItems.add(
            TrendingItem(
                4,
                500,
                20,
                false,
                "https://picsum.photos/200/300",
                "Item Heading",
                "Item Description",
                "Python",
                "https://picsum.photos/200/300",
                "https://picsum.photos/200/300"
            )
        )

        arrayListOfItems.add(
            TrendingItem(
                5,
                500,
                20,
                false,
                "https://picsum.photos/200/300",
                "Item Heading",
                "Item Description",
                "Python",
                "https://picsum.photos/200/300",
                "https://picsum.photos/200/300"
            )
        )

        arrayListOfItems.add(
            TrendingItem(
                6,
                500,
                20,
                false,
                "https://picsum.photos/200/300",
                "Item Heading",
                "Item Description",
                "Python",
                "https://picsum.photos/200/300",
                "https://picsum.photos/200/300"
            )
        )

        arrayListOfItems.add(
            TrendingItem(
                7,
                500,
                20,
                false,
                "https://picsum.photos/200/300",
                "Item Heading",
                "Item Description",
                "Python",
                "https://picsum.photos/200/300",
                "https://picsum.photos/200/300"
            )
        )

        arrayListOfItems.add(
            TrendingItem(
                8,
                500,
                20,
                false,
                "https://picsum.photos/200/300",
                "Item Heading",
                "Item Description",
                "Python",
                "https://picsum.photos/200/300",
                "https://picsum.photos/200/300"
            )
        )

        arrayListOfItems.add(
            TrendingItem(
                9,
                500,
                20,
                false,
                "https://picsum.photos/200/300",
                "Item Heading",
                "Item Description",
                "Python",
                "https://picsum.photos/200/300",
                "https://picsum.photos/200/300"
            )
        )

        arrayListOfItems.add(
            TrendingItem(
                10,
                500,
                20,
                false,
                "https://picsum.photos/200/300",
                "Item Heading",
                "Item Description",
                "Python",
                "https://picsum.photos/200/300",
                "https://picsum.photos/200/300"
            )
        )

        arrayListOfItems.add(
            TrendingItem(
                10,
                500,
                20,
                false,
                "https://picsum.photos/200/300",
                "Item Heading",
                "Item Description",
                "Python",
                "https://picsum.photos/200/300",
                "https://picsum.photos/200/300"
            )
        )

        arrayListOfItems.add(
            TrendingItem(
                10,
                500,
                20,
                false,
                "https://picsum.photos/200/300",
                "Item Heading",
                "Item Description",
                "Python",
                "https://picsum.photos/200/300",
                "https://picsum.photos/200/300"
            )
        )

        arrayListOfItems.add(
            TrendingItem(
                10,
                500,
                20,
                false,
                "https://picsum.photos/200/300",
                "Item Heading",
                "Item Description",
                "Python",
                "https://picsum.photos/200/300",
                "https://picsum.photos/200/300"
            )
        )

        arrayListOfItems.add(
            TrendingItem(
                10,
                500,
                20,
                false,
                "https://picsum.photos/200/300",
                "Item Heading",
                "Item Description",
                "Python",
                "https://picsum.photos/200/300",
                "https://picsum.photos/200/300"
            )
        )

        arrayListOfItems.add(
            TrendingItem(
                10,
                500,
                20,
                false,
                "https://picsum.photos/200/300",
                "Item Heading",
                "Item Description",
                "Python",
                "https://picsum.photos/200/300",
                "https://picsum.photos/200/300"
            )
        )

        arrayListOfItems.add(
            TrendingItem(
                10,
                500,
                20,
                false,
                "https://picsum.photos/200/300",
                "Item Heading",
                "Item Description",
                "Python",
                "https://picsum.photos/200/300",
                "https://picsum.photos/200/300"
            )
        )

        arrayListOfItems.add(
            TrendingItem(
                10,
                500,
                20,
                false,
                "https://picsum.photos/200/300",
                "Item Heading",
                "Item Description",
                "Python",
                "https://picsum.photos/200/300",
                "https://picsum.photos/200/300"
            )
        )

        arrayListOfItems.add(
            TrendingItem(
                10,
                500,
                20,
                false,
                "https://picsum.photos/200/300",
                "Item Heading",
                "Item Description",
                "Python",
                "https://picsum.photos/200/300",
                "https://picsum.photos/200/300"
            )
        )
        setTrendingItemList(arrayListOfItems)
        recyclerViewAdapter.notifyDataSetChanged()
        delay(3000)
        _state.value = MainFragmentUIState.LoadSuccess
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
        } else {
            _state.value =
                MainFragmentUIState.NoInternet(application.getString(R.string.ERROR_MESSAGE_NETWORK_CHECK))

        }
    }

    fun setTrendingItemList(list: List<TrendingItem>) {
        this.trendingItems = list
    }

    fun getRecyclerViewAdapter() = recyclerViewAdapter
    fun getTrendingItems(): List<TrendingItem?> = this.trendingItems
    fun getIsExpanded(position: Int) = trendingItems[position].isItemExpanded
    fun getTitle(position: Int) = trendingItems[position].itemHeading
    fun getGetAvatarLink(position: Int) = trendingItems[position].avatarURL
    fun getDescription(position: Int) = trendingItems[position].itemDescription
    fun getLanguage(position: Int) = trendingItems[position].repositoryLanguage
    fun getStars(position: Int) = trendingItems[position].repositoryStars.toString()
}