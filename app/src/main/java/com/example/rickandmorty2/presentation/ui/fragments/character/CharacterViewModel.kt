package com.example.rickandmorty2.presentation.ui.fragments.character

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.rickandmorty2.base.BaseViewModel
import com.example.rickandmorty2.data.remote.dtos.RickAndMortyResponse
import com.example.rickandmorty2.data.remote.dtos.character.RickAndMortyCharacter
import com.example.rickandmorty2.data.repositories.CharacterRepository

class CharacterViewModel   constructor(
    private val repository: CharacterRepository,
) : BaseViewModel() {

    private var page = 1
    var isLoading: Boolean = false

    private val _characterState = MutableLiveData<RickAndMortyResponse<RickAndMortyCharacter>>()
    val characterState: LiveData<RickAndMortyResponse<RickAndMortyCharacter>> = _characterState


    private val _characterLocaleState = MutableLiveData<List<RickAndMortyCharacter>>()
    val characterLocaleState: LiveData<List<RickAndMortyCharacter>> = _characterLocaleState

    fun fetchCharacter() {
        isLoading = true
        repository.fetchCharacters(page).collect(_characterState) {
            page++
            isLoading = false
        }
    }
    init {
        fetchCharacter()
    }
    fun getCharacters() = repository.getCharacters().collect(_characterLocaleState, null)


}



