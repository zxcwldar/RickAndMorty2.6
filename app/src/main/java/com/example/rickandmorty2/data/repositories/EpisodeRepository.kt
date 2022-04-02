package com.example.rickandmorty2.data.repositories

import com.example.rickandmorty2.base.BaseRepository
import com.example.rickandmorty2.data.local.db.daos.CharacterDao
import com.example.rickandmorty2.data.local.db.daos.EpisodeDao
import com.example.rickandmorty2.data.remote.apiservices.EpisodeApiService
import com.example.rickandmorty2.data.remote.dtos.episode.RickAndMortyEpisode
import javax.inject.Inject

class EpisodeRepository @Inject constructor(
    private val service: EpisodeApiService,
    private val episodeDao: EpisodeDao

) :
    BaseRepository() {
    fun fetchEpisode(page: Int) = doRequest {
        service.fetchEpisodes(page)
    }

    suspend fun insertEpisodes(episodes : List<RickAndMortyEpisode>){
        episodeDao.insertAllEpisode(*episodes.toTypedArray())

    }

    fun getEpisodes() = doRequest {
        episodeDao.getAll()
    }

}