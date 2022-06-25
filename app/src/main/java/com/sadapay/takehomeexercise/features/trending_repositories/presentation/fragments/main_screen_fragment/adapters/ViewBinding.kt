package com.sadapay.takehomeexercise.features.trending_repositories.presentation.fragments.main_screen_fragment.adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class ViewBinding {
    companion object {
        @BindingAdapter(
            value = ["setAdapter"],
            requireAll = false
        )
        @JvmStatic
        fun bindRecyclerViewAdapter(
            recyclerView: RecyclerView,
            adapter: RecyclerView.Adapter<*>?,
        ) {
            recyclerView.setHasFixedSize(true)
            recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
            recyclerView.adapter = adapter
        }


        @BindingAdapter("image")
        @JvmStatic
        fun setImage(image: ImageView, url: String?) {
            Glide.with(image.context).load(url).centerCrop()
                .into(image)
        }
    }
}