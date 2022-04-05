package com.example.rickandmorty2.servicelocator

import com.example.rickandmorty2.data.repositories.CharacterRepository
import com.example.rickandmorty2.data.repositories.EpisodeRepository
import com.example.rickandmorty2.data.repositories.LocationRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory { CharacterRepository(get(), get()) }
    factory { EpisodeRepository(get() , get()) }
    factory { LocationRepository(get() , get()) }
}