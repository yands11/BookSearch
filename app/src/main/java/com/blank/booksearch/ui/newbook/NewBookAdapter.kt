package com.blank.booksearch.ui.newbook

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.blank.booksearch.databinding.HolderBookBinding
import com.blank.booksearch.ui.common.BookUiModel
import com.blank.booksearch.ui.common.BookViewHolder

class NewBookAdapter : ListAdapter<BookUiModel, BookViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        return BookViewHolder(
            HolderBookBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bindItem(getItem(position))
    }

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<BookUiModel>() {
            override fun areItemsTheSame(oldItem: BookUiModel, newItem: BookUiModel): Boolean {
                return oldItem.isbn13 == newItem.isbn13
            }

            override fun areContentsTheSame(oldItem: BookUiModel, newItem: BookUiModel): Boolean {
                return oldItem == newItem
            }
        }
    }
}