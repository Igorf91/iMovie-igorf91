package com.igorf91.imovie.util

import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.igorf91.imovie.R

const val BASE_IMG_URL = "https://image.tmdb.org/t/p/w300"
fun ImageView.loadImage(imageLocation: String, view: View) {
    Glide
        .with(view)
        .load(BASE_IMG_URL + imageLocation)
        .placeholder(getLoaderPlaceholder(view.context))
        .error(R.drawable.img_placeholder)
        .into(this)
}

fun ImageView.loadImage(imageLocation: String, fragment: Fragment) {
    Glide
        .with(fragment)
        .load(BASE_IMG_URL + imageLocation)
        .placeholder(getLoaderPlaceholder(fragment.requireContext()))
        .error(R.drawable.img_placeholder)
        .into(this)
}