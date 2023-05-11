package com.example.rickandmorty.data.service

import com.example.rickandmorty.data.model.MainResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("character")
    fun getCharacters(
        @Query("pages") page: Int? =1
    ) : Call<MainResponse<com.example.rickandmorty.data.model.Result>>

    @GET("character/{id}")
    fun getSingleCharacter(
        @Path("id") id: String,
    ): Call<com.example.rickandmorty.data.model.Result>


}
