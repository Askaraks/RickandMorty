package com.example.rickandmorty.presentation.ui.fragments.character

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmorty.data.model.MainResponse
import com.example.rickandmorty.data.repository.RickAndMortyRepository

class CharacterViewModel : ViewModel() {
    private val repository = RickAndMortyRepository()
    var liveData: LiveData<MainResponse<com.example.rickandmorty
    .data.model.Result>> = MutableLiveData()

    fun getCharacter() {
        liveData = repository.getCharacter()
    }


}