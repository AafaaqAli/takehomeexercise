package com.sadapay.takehomeexercise.features.trending_repositories.presentation.fragments.main_screen_fragment.adapters

import androidx.recyclerview.widget.DiffUtil
import com.sadapay.takehomeexercise.features.trending_repositories.domain.models.TrendingItem

class TrendingItemsDiffUtil(
    private val oldList: List<TrendingItem>,
    private val newList: List<TrendingItem>
) : DiffUtil.Callback() {
    override fun getOldListSize() = oldList.size
    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].itemID == newList[newItemPosition].itemID
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when{
            oldList[oldItemPosition].itemDescription == newList[newItemPosition].itemDescription -> {
                false
            }

            oldList[oldItemPosition].itemHeadingUserName == newList[newItemPosition].itemHeadingUserName -> {
                false
            }

            oldList[oldItemPosition].itemSubHeadingRepositoryName == newList[newItemPosition].itemSubHeadingRepositoryName -> {
                false
            }

            oldList[oldItemPosition].avatarURL == newList[newItemPosition].avatarURL -> {
                false
            }
            else -> true
        }
    }
}