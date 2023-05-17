package com.example.rickandmorty.data.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.rickandmorty.data.repository.LocalRepository
import com.example.rickandmorty.db.RickDao
import com.example.rickandmorty.db.RickDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object LocalModel {

    @Provides
    @Singleton
    fun provideRoom(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        RickDataBase::class.java, "DB_name"
        ).allowMainThreadQueries().build()

    @Provides
    fun provideDao(dataBase: RickDataBase) = dataBase.getDao()

    @Provides
    fun provideLocalRepository(rickDao: RickDao) = LocalRepository(rickDao)

}