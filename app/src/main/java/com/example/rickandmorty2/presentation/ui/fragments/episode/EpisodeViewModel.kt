package com.example.rickandmorty2.presentation.ui.fragments.episode

import com.example.rickandmorty2.base.BaseViewModel
import com.example.rickandmorty2.data.repositories.EpisodeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EpisodeViewModel  @Inject constructor(
    private val episodesRepository: EpisodeRepository
) : BaseViewModel() {
    fun fetchEpisodes() = episodesRepository.fetchEpisodes()
}