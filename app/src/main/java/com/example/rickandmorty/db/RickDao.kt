package com.example.rickandmorty.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RickDao {

    @Query("SELECT * FROM result")
    fun getAllCharacter(): List<com.example.rickandmorty.data.model.Result>

    @Insert
    fun addCharacter(result: com.example.rickandmorty.data.model.Result)
}