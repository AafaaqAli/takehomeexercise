package com.sadapay.takehomeexercise.features.trending_repositories.presentation.fragments.main_screen_fragment

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.DiffUtil
import com.sadapay.app_utils.utils.network.NetworkUtils
import com.sadapay.app_utils.utils.network.NetworkUtils.isNetworkConnected
import com.sadapay.takehomeexercise.R
import com.sadapay.takehomeexercise.features.trending_repositories.domain.models.TrendingItem
import com.sadapay.takehomeexercise.features.trending_repositories.presentation.fragments.main_screen_fragment.adapters.TrendingItemsDiffUtil
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

    private var oldTrendingItems: List<TrendingItem> = arrayListOf()
    private var newTrendingItems: List<TrendingItem> = arrayListOf()

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

        val arrayListOfItems: ArrayList<TrendingItem> = arrayListOf()
        arrayListOfItems.add(
            TrendingItem(
                1,
                500,
                20,
                false,
                "https://picsum.photos/id/110/200/300",
                "Random 1",
                "SadapayTakeHomeExercise1",
                "1-The remake of the https://github.com/aafaqali/sadapayexercise/ in accordance to latest technologies",
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
                "https://picsum.photos/id/180/200/300",
                "Random 2",
                "SadapayTakeHomeExercise2",
                "2-The remake of the https://github.com/aafaqali/sadapayexercise/ in accordance to latest technologies",
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
                "https://picsum.photos/id/154/200/300",
                "Random 3",
                "SadapayTakeHomeExercise3",
                "3-The remake of the https://github.com/aafaqali/sadapayexercise/ in accordance to latest technologies",
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
                "https://picsum.photos/id/1049/200/300",
                "Random 4",
                "SadapayTakeHomeExercise4",
                "4-The remake of the https://github.com/aafaqali/sadapayexercise/ in accordance to latest technologies",
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
                "https://picsum.photos/id/1054/200/300",
                "Random 5",
                "SadapayTakeHomeExercise5",
                "5-The remake of the https://github.com/aafaqali/sadapayexercise/ in accordance to latest technologies",
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
                "https://picsum.photos/id/1069/200/300",
                "Random 6",
                "SadapayTakeHomeExercise6",
                "6-The remake of the https://github.com/aafaqali/sadapayexercise/ in accordance to latest technologies",
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
                "https://picsum.photos/id/1074/200/300",
                "Random 7",
                "SadapayTakeHomeExercise7",
                "7-The remake of the https://github.com/aafaqali/sadapayexercise/ in accordance to latest technologies",
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
                "https://picsum.photos/id/117/200/300",
                "Random 8",
                "SadapayTakeHomeExercise8",
                "8-The remake of the https://github.com/aafaqali/sadapayexercise/ in accordance to latest technologies",
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
                "https://picsum.photos/id/152/200/300",
                "Random 9",
                "SadapayTakeHomeExercise9",
                "9-The remake of the https://github.com/aafaqali/sadapayexercise/ in accordance to latest technologies",
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
                "https://picsum.photos/id/177/200/300",
                "Random 10",
                "SadapayTakeHomeExercise10",
                "10-The remake of the https://github.com/aafaqali/sadapayexercise/ in accordance to latest technologies",
                "Python",
                "https://picsum.photos/200/300",
                "https://picsum.photos/200/300"
            )
        )

        setTrendingItemList(arrayListOfItems)
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

    private fun setTrendingItemList(newTrendingItems: List<TrendingItem>) {
        val diffUtil = TrendingItemsDiffUtil(oldTrendingItems, newTrendingItems)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        this.oldTrendingItems = newTrendingItems
        this.newTrendingItems = newTrendingItems

        diffResult.dispatchUpdatesTo(recyclerViewAdapter)
    }

    fun setIsExpanded(position: Int, expansion: Boolean) {
        newTrendingItems[position].isItemExpanded = expansion
        recyclerViewAdapter.notifyItemChanged(position)
    }

    fun getRecyclerViewAdapter() = recyclerViewAdapter
    fun getTrendingItems(): List<TrendingItem?> = this.oldTrendingItems
    fun getIsExpanded(position: Int) = oldTrendingItems[position].isItemExpanded
    fun getTitleUserName(position: Int) = oldTrendingItems[position].itemHeadingUserName
    fun getRepositoryName(position: Int) = oldTrendingItems[position].itemSubHeadingRepositoryName
    fun getDescription(position: Int) = oldTrendingItems[position].itemDescription
    fun getGetAvatarLink(position: Int) = oldTrendingItems[position].avatarURL
    fun getLanguage(position: Int) = oldTrendingItems[position].repositoryLanguage
    fun getStars(position: Int) = oldTrendingItems[position].repositoryStars.toString()
}