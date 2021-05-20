package com.blank.booksearch.ui.common

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.blank.booksearch.databinding.HolderBookBinding

class BookAdapter(
    private val clickListener: (String) -> Unit
) : ListAdapter<BookUiModel, BookViewHolder>(diffCallback) {

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
