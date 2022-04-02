package com.example.rickandmorty2.data.remote.dtos.character

import com.example.rickandmorty2.base.BaseDiffModel
import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("id")
    override val id: Int,
) : BaseDiffModel