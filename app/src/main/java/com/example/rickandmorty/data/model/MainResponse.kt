package com.example.rickandmorty.data.model

data class MainResponse<T>(
    val info: Info,
    val results: List<T>
)