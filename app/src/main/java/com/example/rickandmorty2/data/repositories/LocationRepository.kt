package com.example.rickandmorty2.data.repositories

import com.example.rickandmorty2.base.BaseRepository
import com.example.rickandmorty2.data.local.db.daos.LocationDao
import com.example.rickandmorty2.data.remote.apiservices.LocationApiService

class LocationRepository constructor(
    private val service: LocationApiService,
    private val locationDao: LocationDao
) :
    BaseRepository() {

    fun fetchLocation(page: Int) = doRequest(
        { service.fetchLocations(page) },
        { location -> locationDao.insertAllLocation(* location.results.toTypedArray()) })


    fun getLocations() = doRequest {
        locationDao.getAllLocation()
    }
}

