package com.blank.booksearch.ui

import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
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

fun View.closeKeypad() =
    context.getSystemService(AppCompatActivity.INPUT_METHOD_SERVICE)?.let { inputMethodService ->
        inputMethodService as? InputMethodManager
    }?.hideSoftInputFromWindow(this.windowToken, 0)
