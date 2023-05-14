package com.example.rickandmorty.data.service

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.rickandmorty.data.model.Episode
import com.example.rickandmorty.data.model.Location
import com.example.rickandmorty.data.model.MainResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("character")
    fun getCharacters(
        @Query("pages") page: Int
    ) : Call<MainResponse<com.example.rickandmorty.data.model.Result>>

    @GET("character/{id}")
    fun getSingleCharacter(
        @Path("id") id: String,
    ): Call<com.example.rickandmorty.data.model.Result>

    @GET("location")
    fun getLocations(@Query("page") page: Int): Call<MainResponse<Location>>


    @GET("episode")
    fun getEpisodes(@Query("page") page: Int): Call<MainResponse<Episode>>

}
