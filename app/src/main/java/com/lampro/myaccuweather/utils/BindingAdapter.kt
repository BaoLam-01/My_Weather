package com.lampro.myaccuweather.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object BindingAdapter {
    @BindingAdapter("imageUrl")
    @JvmStatic
    fun bindUrl2Image(imageView: ImageView, weatherIcon: Int?) {
        val formattedNumber = String.format("%02d",weatherIcon)
        Glide.with(imageView.context).load("https://developer.accuweather.com/sites/default/files/$formattedNumber-s.png").into(imageView)
    }
}