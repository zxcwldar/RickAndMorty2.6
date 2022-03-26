package com.example.rickandmorty2.data.remote.apiservices

import com.example.rickandmorty2.data.remote.dtos.RickAndMortyResponse
import com.example.rickandmorty2.data.remote.dtos.location.RickAndMortyLocation
import retrofit2.http.GET
import retrofit2.http.Query

interface LocationApiService {

    @GET("api/location")
    suspend fun fetchLocations(
        @Query("page") page: Int,
    ): RickAndMortyResponse<RickAndMortyLocation>
}