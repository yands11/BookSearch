package com.blank.booksearch.ui

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.blank.booksearch.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

@BindingAdapter("url")
fun ImageView.loadImage(url: String?) = url?.let {
    Glide.with(this)
        .load(it)
        .error(R.drawable.ic_error)
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(this)
}