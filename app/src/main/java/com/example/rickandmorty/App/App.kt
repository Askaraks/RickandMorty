package com.example.rickandmorty.App

import android.app.Application
import com.example.rickandmorty.data.service.ApiService

class App : Application() {

    companion object {
        lateinit var service: ApiService
    }
}