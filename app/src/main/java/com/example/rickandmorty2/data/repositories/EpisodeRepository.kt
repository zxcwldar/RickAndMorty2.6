package com.example.rickandmorty2.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.rickandmorty2.data.remote.apiservices.EpisodeApiService
import com.example.rickandmorty2.data.remote.pagingsources.EpisodePagingSource
import javax.inject.Inject

class EpisodeRepository @Inject constructor(
    private val episodeApiService: EpisodeApiService
) {
    fun fetchEpisodes() = Pager(
        PagingConfig(pageSize = 20)
    ) {
        EpisodePagingSource(episodeApiService)
    }.flow


}