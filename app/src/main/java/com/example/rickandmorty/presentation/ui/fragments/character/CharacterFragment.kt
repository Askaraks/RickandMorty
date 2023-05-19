package com.example.rickandmorty.presentation.ui.fragments.character

import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.rickandmorty.R
import com.example.rickandmorty.base.BaseFragment
import com.example.rickandmorty.databinding.FragmentCharacterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterFragment : BaseFragment<FragmentCharacterBinding>(FragmentCharacterBinding:: inflate) {

    // инициализация только при использовании
    private val viewModel : CharacterViewModel by viewModels()
    lateinit var adapter: CharacterAdapter
    private var pager = 1
    // сразу инициализация, но добавить библиотеку lifecycle private val viewModel: CharacterViewModel by viewModels()
    override fun setupUI() {
        adapter = CharacterAdapter( click = { id ->
            val bundle = Bundle()
            bundle.putInt("id", id)
            findNavController().navigate(R.id.recyclerMovieList, bundle)
        }, onLongClick = {
            viewModel.addCharacter(it)
            Toast.makeText(requireContext(),
                "сохранение персонажа по имени ${it.nameCharacter}", Toast.LENGTH_SHORT).show()
        })
        binding.recyclerMovieList.adapter = adapter
    }
    override fun setupObserver() {
        viewModel.getCharacter(pager)
        viewModel.liveData.observe(viewLifecycleOwner) {
            adapter.setList(it.results)
        }
        binding.refresh.setOnRefreshListener {
            pager++
            Toast.makeText(requireContext(), "swipe", Toast.LENGTH_SHORT).show()
            viewModel.getCharacter(pager)
            viewModel.liveData.observe(viewLifecycleOwner) {
                adapter.setList(it.results)
            }
            binding.refresh.isRefreshing = false
        }
    }

    private fun getResult(page: Int) {
    }
}
