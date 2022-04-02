package com.example.rickandmorty2.presentation.ui.fragments.location

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty2.base.BaseViewModel
import com.example.rickandmorty2.common.resourse.Resource
import com.example.rickandmorty2.data.remote.dtos.RickAndMortyResponse
import com.example.rickandmorty2.data.remote.dtos.location.RickAndMortyLocation
import com.example.rickandmorty2.data.repositories.LocationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(
    private val repository: LocationRepository
) : BaseViewModel() {

    private var page = 1
    var isLoading: Boolean = false
    private val _locationsState = MutableLiveData<RickAndMortyResponse<RickAndMortyLocation>>()
    val locationsState: LiveData<RickAndMortyResponse<RickAndMortyLocation>> = _locationsState

    private val _locationsLocaleState = MutableLiveData<List<RickAndMortyLocation>>()
    val episodesLocaleState: LiveData<List<RickAndMortyLocation>> = _locationsLocaleState

    fun fetchLocation() {
        isLoading = true
        repository.fetchLocation(page).collect(_locationsState) {
            page++
            isLoading = false
        }
    }

    fun getLocation() = repository.getLocations().collect(_locationsLocaleState, null)


}