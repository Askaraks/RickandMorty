package com.example.rickandmorty.presentation.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmorty.data.repository.LocalRepository
import com.example.rickandmorty.data.repository.RickAndMortyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class FavoriteViewModel @Inject constructor(private val repository: LocalRepository): ViewModel()
{

    val livedata = MutableLiveData<List<com.example.rickandmorty.data.model.Result>>()
    fun getAllFavourite() {
        livedata.value = repository.getFavoriteCharacters()
    }


}