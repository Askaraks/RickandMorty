package com.example.rickandmorty.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity(tableName = "result")
data class Result(
    @SerializedName("gender")
    val gender: String,
    @SerializedName("id")
    @PrimaryKey
    val id: Int,
    @SerializedName("image")
    val imgUrl: String,
    @SerializedName("name")
    val nameCharacter: String,
    @SerializedName("status")
    val statusLife: String,
    @SerializedName("species")
    val type: String,
)