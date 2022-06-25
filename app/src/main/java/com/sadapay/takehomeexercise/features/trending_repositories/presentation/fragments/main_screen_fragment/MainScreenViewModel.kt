package com.sadapay.takehomeexercise.features.trending_repositories.presentation.fragments.main_screen_fragment

import androidx.lifecycle.ViewModel
import com.sadapay.takehomeexercise.features.trending_repositories.domain.models.TrendingItem
import com.sadapay.takehomeexercise.features.trending_repositories.presentation.fragments.main_screen_fragment.adapters.TrendingRepositoriesAdapter
import com.sadapay.takehomeexercise.features.trending_repositories.presentation.fragments.main_screen_fragment.ui_states.MainFragmentUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainScreenViewModel(): ViewModel() {
    private val _state = MutableStateFlow<MainFragmentUIState>(MainFragmentUIState.Empty)
    val mainScreenStateFlow: StateFlow<MainFragmentUIState> = _state

    private var trendingItems: List<TrendingItem> = ArrayList()
    private val recyclerViewAdapter: TrendingRepositoriesAdapter = TrendingRepositoriesAdapter()

    init {
        recyclerViewAdapter.setRecyclerViewViewModel(this)
    }

    fun populateRecyclerView() {
        /**
         * For now use notifyDataSetChanged but use diff-utils
         * */
        val arrayListOfItems: ArrayList<TrendingItem> = arrayListOf()
        arrayListOfItems.add(TrendingItem(
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
        ))

        arrayListOfItems.add(TrendingItem(
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
        ))

        arrayListOfItems.add(TrendingItem(
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
        ))

        arrayListOfItems.add(TrendingItem(
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
        ))

        arrayListOfItems.add(TrendingItem(
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
        ))

        arrayListOfItems.add(TrendingItem(
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
        ))

        arrayListOfItems.add(TrendingItem(
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
        ))

        arrayListOfItems.add(TrendingItem(
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
        ))

        arrayListOfItems.add(TrendingItem(
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
        ))

        arrayListOfItems.add(TrendingItem(
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
        ))

        arrayListOfItems.add(TrendingItem(
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
        ))

        arrayListOfItems.add(TrendingItem(
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
        ))

        arrayListOfItems.add(TrendingItem(
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
        ))

        arrayListOfItems.add(TrendingItem(
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
        ))

        arrayListOfItems.add(TrendingItem(
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
        ))

        arrayListOfItems.add(TrendingItem(
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
        ))

        arrayListOfItems.add(TrendingItem(
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
        ))

        arrayListOfItems.add(TrendingItem(
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
        ))

        arrayListOfItems.add(TrendingItem(
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
        ))
        setTrendingItemList(arrayListOfItems)
        recyclerViewAdapter.notifyDataSetChanged()
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