package com.nizzle94.architecturecomponentmvp.util

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Created by Khajiev Nizomjon on 09/06/2018.
 */
object BindingAdapterUtils {

    @JvmStatic
    @BindingAdapter("imageUrl")
    fun setImageUrl(imageView: ImageView, url: String?) {
        Glide.with(imageView.context).load("https://image.tmdb.org/t/p/w500/$url").into(imageView)
    }

}