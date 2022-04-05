package com.example.rickandmorty2.data.repositories

import com.example.rickandmorty2.base.BaseRepository
import com.example.rickandmorty2.data.local.db.daos.CharacterDao
import com.example.rickandmorty2.data.remote.apiservices.CharacterApiService

class CharacterRepository  constructor(
    private val service: CharacterApiService,
    private val characterDao: CharacterDao
 ) :
    BaseRepository() {
    fun fetchCharacters(page: Int) = doRequest(
        { service.fetchCharacters(page) },
        { characters ->
            characterDao.insertAll(*characters.results.toTypedArray())
        }
    )

    fun getCharacters() = doRequest {
        characterDao.getAll()
    }
}