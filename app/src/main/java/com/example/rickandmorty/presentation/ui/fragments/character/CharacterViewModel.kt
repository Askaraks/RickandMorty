package com.example.rickandmorty.presentation.ui.fragments.character

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmorty.data.model.MainResponse
import com.example.rickandmorty.data.repository.LocalRepository
import com.example.rickandmorty.data.repository.RickAndMortyRepository
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(private val repository: RickAndMortyRepository,
                                     private val localRepository: LocalRepository) : ViewModel() {


    var liveData: LiveData<MainResponse<com.example.rickandmorty
    .data.model.Result>> = MutableLiveData()


    fun getCharacter(pager: Int) {
        liveData = repository.getCharacter(pager)
    }
    fun addCharacter(result: com.example.rickandmorty.data.model.Result) {
        localRepository.addCharacter(result)
    }


}