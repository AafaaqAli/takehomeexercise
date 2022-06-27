package com.sadapay.takehomeexercise.features.trending_repositories.presentation.fragments.main_screen_fragment.adapters

import android.annotation.SuppressLint
import android.app.PendingIntent.getActivity
import android.graphics.Color
import android.graphics.PorterDuff
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sadapay.takehomeexercise.R


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

        @BindingAdapter("drawableRight")
        @JvmStatic
        fun setDrawableBackground(textView: TextView, color: String) {
            var rightDrawable = ContextCompat.getDrawable(textView.context, R.drawable.language_drawable)
            rightDrawable?.setTint(Color.parseColor(color))
            textView.setCompoundDrawablesWithIntrinsicBounds(rightDrawable,null, null ,null)
        }
    }
}