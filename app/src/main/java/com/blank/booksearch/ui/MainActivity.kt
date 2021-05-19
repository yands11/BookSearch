package com.blank.booksearch.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.blank.booksearch.R
import com.blank.booksearch.databinding.ActivityMainBinding
import com.blank.booksearch.ui.detail.BookDetailFragment
import com.blank.booksearch.ui.search.SearchBookFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.commit {
            replace(R.id.container, BookDetailFragment.newInstance("9783030053178"))
//            replace<SearchBookFragment>(R.id.container)
        }
    }
}