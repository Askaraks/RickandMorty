package com.example.rickandmorty.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.rickandmorty.data.model.Episode
import com.example.rickandmorty.data.model.Location
import com.example.rickandmorty.data.model.MainResponse
import com.example.rickandmorty.data.model.Result
import com.example.rickandmorty.data.service.ApiService
import com.example.rickandmorty.data.service.retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RickAndMortyRepository @Inject constructor(private val apiService: ApiService)
{


    fun getCharacter(pager: Int): LiveData<MainResponse<Result>> {
        val liveData = MutableLiveData<MainResponse<Result>>()
        apiService.getCharacters(pager).enqueue(object : retrofit2.Callback<MainResponse<Result>> {
            override fun onResponse(
                call: Call<MainResponse<Result>>,
                response: Response<MainResponse<Result>>
            ) {
                liveData.value = response.body()
            }
            override fun onFailure(call: Call<MainResponse<Result>>, t: Throwable) {
                t.localizedMessage?.let { Log.e("Walter", it) }
            }
        })
        return liveData
    }


    fun getLocation(pager: Int): LiveData<MainResponse<Location>> {
        val liveData = MutableLiveData<MainResponse<Location>>()

        apiService.getLocations(pager).enqueue(object: Callback<MainResponse<Location>> {
            override fun onResponse(
                call: Call<MainResponse<Location>>,
                response: Response<MainResponse<Location>>
            ) {
                liveData.value = response.body()

            }

            override fun onFailure(call: Call<MainResponse<Location>>, t: Throwable) {
                t.localizedMessage?.let { Log.e("Walter", it) }
            }
        })
        return liveData
    }
    fun getEpisode(pager: Int): LiveData<MainResponse<Episode>> {
        val liveData = MutableLiveData<MainResponse<Episode>>()

        apiService.getEpisodes(pager).enqueue(object: Callback<MainResponse<Episode>> {
            override fun onResponse(
                call: Call<MainResponse<Episode>>,
                response: Response<MainResponse<Episode>>
            ) {
                liveData.value = response.body()
            }

            override fun onFailure(call: Call<MainResponse<Episode>>, t: Throwable) {
                t.localizedMessage?.let { Log.e("Walter", it) }
            }
        })
        return liveData
    }
    fun getDetail(id: String): LiveData<Result> {
        val liveData = MutableLiveData<Result>()
        apiService.getSingleCharacter(id).enqueue(object : Callback<Result> {
            override fun onResponse(
                call: Call<Result>,
                response: Response<Result>
            ) {
                liveData.value = response.body()
            }

            override fun onFailure(call: Call<Result>, t: Throwable) {
                t.localizedMessage?.let { Log.e("Walter", it) }
            }

        })
        return liveData
    }
}