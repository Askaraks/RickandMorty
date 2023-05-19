package com.example.rickandmorty.presentation.ui.fragments.location

import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rickandmorty.base.BaseFragment
import com.example.rickandmorty.databinding.FragmentLocationBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LocationFragment: BaseFragment<FragmentLocationBinding>(FragmentLocationBinding::inflate) {

    lateinit var adapter: LocationAdapter

    private var page = 1
    private val viewModel : LocationViewModel by viewModels()

    override fun setupUI() {
        adapter = LocationAdapter()
        viewModel.getLocation(page)
    }

    override fun setupObserver() {
        getResult()

        binding.fragLocation.setOnRefreshListener {
            page++
            viewModel.getLocation(page)
            getResult()
            binding.fragLocation.isRefreshing = false
        }
    }

    private fun getResult() {
        viewModel.liveData.observe(viewLifecycleOwner) {
            adapter.setList(it.results)
            binding.location.adapter = adapter
        }
    }
}