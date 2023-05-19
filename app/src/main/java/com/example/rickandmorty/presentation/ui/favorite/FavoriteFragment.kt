package com.example.rickandmorty.presentation.ui.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.example.rickandmorty.R
import com.example.rickandmorty.base.BaseFragment
import com.example.rickandmorty.databinding.FragmentFavoriteBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : BaseFragment<FragmentFavoriteBinding>(FragmentFavoriteBinding::inflate) {

    lateinit var adapter: FavoriteAdapter

    private val ViewModel :FavoriteViewModel by viewModels()

    override fun setupUI() {
        adapter = FavoriteAdapter()
        ViewModel.getAllFavourite()
    }

    override fun setupObserver() {
        ViewModel.livedata.observe(viewLifecycleOwner) {
            adapter.setList(it)
            binding.rvFavorite.adapter = adapter
        }
    }

}