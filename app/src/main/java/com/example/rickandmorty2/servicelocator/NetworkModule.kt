package com.example.rickandmorty2.servicelocator

import com.example.rickandmorty2.data.remote.RetrofitClient
import org.koin.dsl.module

val networkModule = module {
    single { RetrofitClient() }
    single { get<RetrofitClient>().provideCharactersApiService() }
    single { get<RetrofitClient>().provideEpisodesApiService() }
    single { get<RetrofitClient>().provideLocationApiService()  }


}