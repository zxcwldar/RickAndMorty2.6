package com.example.rickandmorty2.servicelocator

import com.example.rickandmorty2.data.local.db.RoomClient
import org.koin.dsl.module


val appDatabaseModule = module {

    single { RoomClient() }
    single { get<RoomClient>().provideCreateAppDatabase(get()) }
    single { get<RoomClient>().provideCharacterDao(get()) }
    single { get<RoomClient>().provideLocationDao(get()) }
    single { get<RoomClient>().provideEpisodeDao(get()) }
}