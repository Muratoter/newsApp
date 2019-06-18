package com.moter.newsapp.ui

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 * Created by moter on 18.06.2019.
 */
object NewsBinding {

    @BindingAdapter("imageUrl")
    @JvmStatic
    fun setImageUrl(imageview: ImageView, url: String?) {
        Glide.with(imageview.context).load(url).into(imageview)
    }
}