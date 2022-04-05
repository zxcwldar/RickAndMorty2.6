package com.example.rickandmorty2.servicelocator

import com.example.rickandmorty2.presentation.ui.fragments.character.CharacterViewModel
import com.example.rickandmorty2.presentation.ui.fragments.episode.EpisodeViewModel
import com.example.rickandmorty2.presentation.ui.fragments.location.LocationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { CharacterViewModel(get()) }
    viewModel { EpisodeViewModel(get()) }
    viewModel { LocationViewModel(get()) }

}