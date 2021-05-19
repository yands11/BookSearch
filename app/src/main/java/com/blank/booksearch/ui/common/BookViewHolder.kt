package com.blank.booksearch.ui.common

import androidx.recyclerview.widget.RecyclerView
import com.blank.booksearch.databinding.HolderBookBinding

class BookViewHolder(
    private val binding: HolderBookBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bindItem(item: BookUiModel) {
        binding.item = item
        binding.executePendingBindings()
    }
}