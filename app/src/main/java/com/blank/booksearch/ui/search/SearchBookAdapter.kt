package com.blank.booksearch.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.blank.booksearch.databinding.HolderBookBinding
import com.blank.booksearch.ui.common.BookUiModel
import com.blank.booksearch.ui.common.BookViewHolder

class SearchBookAdapter(
    private val clickListener: (String) -> Unit
) : PagingDataAdapter<BookUiModel, BookViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val binding = HolderBookBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return BookViewHolder(binding).also { holder ->
            binding.root.setOnClickListener {
                getItem(holder.bindingAdapterPosition)?.isbn13?.let(clickListener::invoke)
            }
        }
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        getItem(position)?.let(holder::bindItem)
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
