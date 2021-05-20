package com.blank.booksearch.ui.newbook

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.blank.booksearch.databinding.FragmentNewBookBinding
import com.blank.booksearch.ui.common.BookAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewBookFragment : Fragment() {

    private var _binding: FragmentNewBookBinding? = null
    private val binding get() = _binding!!

    private val vm: NewBookViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewBookBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = BookAdapter { isbn ->
            findNavController().navigate(
                NewBookFragmentDirections.actionNewFragmentToBookDetailFragment(isbn)
            )
        }
        binding.rvNew.adapter = adapter
        vm.bookUiModel.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
