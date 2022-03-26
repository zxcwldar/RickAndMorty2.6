package com.example.rickandmorty2.data.repositories

import androidx.lifecycle.liveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.rickandmorty2.common.resourse.Resource
import com.example.rickandmorty2.data.remote.apiservices.CharacterApiService
import com.example.rickandmorty2.data.remote.pagingsources.CharacterPagingSource
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class CharacterRepository  @Inject constructor(
    private val characterApiService: CharacterApiService,
) {
    fun fetchCharacters() = Pager(PagingConfig(pageSize = 20)) {
        CharacterPagingSource(characterApiService)
    }.flow

    fun fetchSingleCharacter(id: Int) = liveData(Dispatchers.IO) {
        emit(Resource.Loading())


        try {
            emit(Resource.Success(characterApiService.fetchSingleCharacter(id)))

        } catch (ioException: Exception) {
            emit(Resource.Error(null, ioException.localizedMessage))
        }
    }

}