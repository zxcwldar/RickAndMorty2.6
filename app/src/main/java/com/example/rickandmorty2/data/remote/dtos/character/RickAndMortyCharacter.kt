package com.example.rickandmorty2.data.remote.dtos.character

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.rickandmorty2.base.BaseDiffModel
import com.google.gson.annotations.SerializedName

@Entity
data class RickAndMortyCharacter(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    override val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("species")
    val species: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("image")
    val image: String,
) : BaseDiffModel