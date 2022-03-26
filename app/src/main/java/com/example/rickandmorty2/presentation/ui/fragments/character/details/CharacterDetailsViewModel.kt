package com.example.rickandmorty2.presentation.ui.fragments.character.details

import com.example.rickandmorty2.base.BaseViewModel
import com.example.rickandmorty2.data.repositories.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class CharacterDetailsViewModel @Inject constructor(
    private val characterRepository: CharacterRepository
) : BaseViewModel() {

    fun fetchSingleCharacter(id: Int) =
        characterRepository.fetchSingleCharacter(id)
}