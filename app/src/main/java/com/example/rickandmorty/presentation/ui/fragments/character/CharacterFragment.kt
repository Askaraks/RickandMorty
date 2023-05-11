package com.example.rickandmorty.presentation.ui.fragments.character

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.rickandmorty.R
import com.example.rickandmorty.base.BaseFragment
import com.example.rickandmorty.databinding.FragmentCharacterBinding

class CharacterFragment : BaseFragment<FragmentCharacterBinding>(FragmentCharacterBinding:: inflate) {


    private var page: Int = 1
    // инициализация только при использовании
    private val viewModel by lazy { ViewModelProvider(requireActivity())[CharacterViewModel::class.java] }
    lateinit var adapter: CharacterAdapter
    // сразу инициализация, но добавить библиотеку lifecycle private val viewModel: CharacterViewModel by viewModels()
    override fun setupUI() {
        adapter = CharacterAdapter( click = { id ->
            val bundle = Bundle()
            bundle.putInt("id", id)
            findNavController().navigate(R.id.recyclerMovieList, bundle)
        })
        binding.recyclerMovieList.setHasFixedSize(true)
        binding.recyclerMovieList
        viewModel.getCharacter()
    }
    override fun setupObserver() {
            viewModel.liveData.observe(viewLifecycleOwner) {
                adapter.setList(it.results as ArrayList<com.example.rickandmorty.data.model.Result>)
                binding.recyclerMovieList.adapter = adapter
            }

            //binding.refresh.setOnRefreshListener {
                //binding.refresh.isRefreshing = false
                //page++
                //viewModel.getCharacter()
            //}
        }
    }
