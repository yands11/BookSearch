package com.blank.booksearch.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.blank.booksearch.databinding.FragmentBookDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BookDetailFragment : Fragment() {

    private val args: BookDetailFragmentArgs by navArgs()

    private lateinit var binding: FragmentBookDetailBinding
    private val vm: BookDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentBookDetailBinding.inflate(inflater, container, false).apply {
        vm = this@BookDetailFragment.vm.also { it.setupIsbn(args.isbn) }
        lifecycleOwner = viewLifecycleOwner
    }.also { binding = it }.root

}
