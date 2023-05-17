package com.example.rickandmorty.data.repository

import androidx.lifecycle.LiveData
import com.example.rickandmorty.data.model.Result
import com.example.rickandmorty.db.RickDao
import javax.inject.Inject

class LocalRepository @Inject constructor(private val rickDao: RickDao) {
    fun  getFavoriteCharacters(): List<Result> {
        return rickDao.getAllCharacter()
    }
    fun addCharacter(result: com.example.rickandmorty.data.model.Result) {
        rickDao.addCharacter(result)
    }

}