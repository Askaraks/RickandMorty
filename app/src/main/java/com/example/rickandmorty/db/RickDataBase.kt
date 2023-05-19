package com.example.rickandmorty.db

import androidx.room.Database
import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper

@Database(entities = [com.example.rickandmorty.data.model.Result::class], version = 2)
abstract class RickDataBase : RoomDatabase() {
    abstract fun getDao(): RickDao
}