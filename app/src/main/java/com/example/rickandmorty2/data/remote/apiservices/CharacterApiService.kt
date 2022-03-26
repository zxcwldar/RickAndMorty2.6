package com.example.rickandmorty2.data.remote.apiservices

import com.example.rickandmorty2.data.remote.dtos.RickAndMortyResponse
import com.example.rickandmorty2.data.remote.dtos.character.RickAndMortyCharacter
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterApiService {
    @GET("api/character")
    suspend fun fetchCharacters(
        @Query("page") page: Int,
    ): RickAndMortyResponse<RickAndMortyCharacter>

    @GET("api/character/{id}")
    suspend fun fetchSingleCharacter(@Path("id") id: Int): RickAndMortyCharacter
}