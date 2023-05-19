package com.example.rickandmorty.App

import android.app.Application
import com.example.rickandmorty.data.service.ApiService
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    companion object {
        lateinit var service: ApiService
    }
}