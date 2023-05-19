package com.example.rickandmorty.presentation.ui.fragments.location

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmorty.data.model.Location
import com.example.rickandmorty.data.model.MainResponse
import com.example.rickandmorty.data.model.Result
import com.example.rickandmorty.data.repository.RickAndMortyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(
    private val repository : RickAndMortyRepository
):ViewModel() {
    var liveData: LiveData<MainResponse<Location>> = MutableLiveData()
    fun getLocation(pager:Int) {
        liveData = repository.getLocation(pager)
    }

}