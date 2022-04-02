package com.example.rickandmorty2.data.remote.dtos.location

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.rickandmorty2.base.BaseDiffModel
import com.google.gson.annotations.SerializedName
@Entity
data class RickAndMortyLocation(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    override val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("dimension")
    val dimension: String
) : BaseDiffModel