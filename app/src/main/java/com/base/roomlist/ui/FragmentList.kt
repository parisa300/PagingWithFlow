package com.base.roomlist.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.base.roomlist.databinding.FragmentListBinding
import com.base.roomlist.ui.adapter.UsersAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FragmentList : Fragment() {
   private val viewModel:FrgmentViewModel by viewModels()
    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val userAdapter = UsersAdapter {

        }.apply { addLoadStateListener { binding.loadState = it.refresh } }

        binding.userAdapter = userAdapter

        lifecycleScope.launch {
            viewModel.flow.collectLatest { pagingData ->
                userAdapter.submitData(pagingData)

            }
        }
    }
}