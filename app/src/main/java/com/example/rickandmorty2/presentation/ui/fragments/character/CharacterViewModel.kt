package com.example.rickandmorty2.presentation.ui.fragments.character

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.rickandmorty2.base.BaseViewModel
import com.example.rickandmorty2.data.repositories.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val characterRepository: CharacterRepository
) : BaseViewModel() {


    fun fetchCharacters() =
        characterRepository.fetchCharacters().cachedIn(viewModelScope)
}