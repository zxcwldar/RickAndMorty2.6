package com.example.rickandmorty2.data.local.db

import android.content.Context
import androidx.room.Room
import com.example.rickandmorty2.data.local.db.daos.CharacterDao
import com.example.rickandmorty2.data.local.db.daos.EpisodeDao
import com.example.rickandmorty2.data.local.db.daos.LocationDao

class RoomClient {
    fun provideCreateAppDatabase(context: Context) = Room.databaseBuilder(
    context, AppDatabase::class.java, "database-name"
    ).fallbackToDestructiveMigration()
    .build()

    fun provideCharacterDao(appDatabase: AppDatabase): CharacterDao = appDatabase.characterDao()

    fun provideEpisodeDao(appDatabase: AppDatabase): EpisodeDao = appDatabase.episodeDao()

    fun provideLocationDao(appDatabase: AppDatabase): LocationDao = appDatabase.locationDao()
}