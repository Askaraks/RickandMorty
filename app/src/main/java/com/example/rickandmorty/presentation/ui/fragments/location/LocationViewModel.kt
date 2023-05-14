package com.example.rickandmorty.presentation.ui.fragments.location

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmorty.data.model.Location
import com.example.rickandmorty.data.model.MainResponse
import com.example.rickandmorty.data.model.Result
import com.example.rickandmorty.data.repository.RickAndMortyRepository

class LocationViewModel:ViewModel() {

    private val repository = RickAndMortyRepository()
    var liveData: LiveData<MainResponse<Location>> = MutableLiveData()

    fun getLocation(pager:Int) {
        liveData = repository.getLocation(pager)
    }

}