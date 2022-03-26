package com.example.rickandmorty2.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.rickandmorty2.data.remote.apiservices.LocationApiService
import com.example.rickandmorty2.data.remote.pagingsources.LocationPagingSource
import javax.inject.Inject

class LocationRepository  @Inject constructor(
    private val locationApiService: LocationApiService
) {
    fun fetchLocations() = Pager(PagingConfig(pageSize = 20)) {
        LocationPagingSource(locationApiService)
    }.flow


}