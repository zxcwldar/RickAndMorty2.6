package com.example.rickandmorty2.data.local.db.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.rickandmorty2.data.remote.dtos.character.RickAndMortyCharacter
import kotlinx.coroutines.flow.Flow


@Dao
interface CharacterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg character:RickAndMortyCharacter)

    @Query("SELECT * FROM rickandmortycharacter" )
    suspend fun getAll() : List<RickAndMortyCharacter>
}