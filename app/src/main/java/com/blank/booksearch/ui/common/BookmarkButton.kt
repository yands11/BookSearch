package com.blank.booksearch.ui.common

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.blank.booksearch.R
import com.blank.booksearch.databinding.ButtonBookmarkBinding

class BookmarkButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {


    private val binding = ButtonBookmarkBinding.inflate(
        LayoutInflater.from(context),
        this,
        true
    )

    fun setBookmark(bookmarked: Boolean) {
        binding.tvBookmark.setTextColor(
            ContextCompat.getColor(
                context,
                if (bookmarked) R.color.selected
                else R.color.unselected
            )
        )
        binding.ivIcon.setImageResource(
            if (bookmarked) R.drawable.ic_baseline_check_circle_24
            else R.drawable.ic_baseline_check_circle_outline_24
        )
    }
}

