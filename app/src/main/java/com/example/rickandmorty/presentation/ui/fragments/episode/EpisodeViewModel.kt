package com.example.rickandmorty.presentation.ui.fragments.episode

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmorty.data.model.Episode
import com.example.rickandmorty.data.model.Location
import com.example.rickandmorty.data.model.MainResponse
import com.example.rickandmorty.data.repository.RickAndMortyRepository

class EpisodeViewModel : ViewModel() {

    private val repository = RickAndMortyRepository()
    var liveData: LiveData<MainResponse<Episode>> = MutableLiveData()

    fun getEpisode(pager:Int) {
        liveData = repository.getEpisode(pager)
    }

}

