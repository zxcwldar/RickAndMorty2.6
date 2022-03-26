package com.example.rickandmorty2.presentation.ui.fragments.location

import com.example.rickandmorty2.base.BaseViewModel
import com.example.rickandmorty2.data.repositories.LocationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(
    private val locationsRepository: LocationRepository
) : BaseViewModel() {
    fun fetchLocations() = locationsRepository.fetchLocations()
}