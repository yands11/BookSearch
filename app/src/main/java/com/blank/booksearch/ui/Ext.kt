package com.blank.booksearch.ui

import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.blank.booksearch.R
import com.blank.booksearch.ui.common.BookmarkButton
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

@BindingAdapter("isSelected")
fun BookmarkButton.bindSelected(isSelected: Boolean?) = isSelected?.let {
    visibility = View.VISIBLE
    setBookmark(isSelected)
}

@BindingAdapter("click")
fun View.bindClickListener(clickListener: (() -> Unit)?) = clickListener?.let {
    setOnClickListener { clickListener.invoke() }
}

fun View.closeKeypad() =
    context.getSystemService(AppCompatActivity.INPUT_METHOD_SERVICE)?.let { inputMethodService ->
        inputMethodService as? InputMethodManager
    }?.hideSoftInputFromWindow(this.windowToken, 0)
