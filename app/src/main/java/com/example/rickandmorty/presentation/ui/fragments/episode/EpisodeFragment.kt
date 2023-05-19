package com.example.rickandmorty.presentation.ui.fragments.episode

import androidx.lifecycle.ViewModelProvider
import com.example.rickandmorty.base.BaseFragment
import com.example.rickandmorty.databinding.FragmentEpisodeBinding
import com.example.rickandmorty.presentation.ui.fragments.character.CharacterAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EpisodeFragment: BaseFragment<FragmentEpisodeBinding>(FragmentEpisodeBinding::inflate) {

    lateinit var adapter: EpisodeAdapter
    private var page = 1
    private val viewModel : EpisodeViewModel by lazy {
        ViewModelProvider(requireActivity())[EpisodeViewModel::class.java] }

    override fun setupUI() {
        adapter = EpisodeAdapter()
        viewModel.getEpisode(page)

    }

    override fun setupObserver() {
        getResult()
        binding.fragLocation.setOnRefreshListener {
            page++
            viewModel.getEpisode(page)
            getResult()
            binding.fragLocation.isRefreshing = false
        }
    }

    private fun getResult() {
        viewModel.liveData.observe(viewLifecycleOwner){
            adapter.setList(it.results)
            binding.location.adapter = adapter
        }
    }
}