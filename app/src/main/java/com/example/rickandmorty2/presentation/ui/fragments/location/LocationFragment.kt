package com.example.rickandmorty2.presentation.ui.fragments.location

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmorty2.R
import com.example.rickandmorty2.base.BaseFragment
import com.example.rickandmorty2.databinding.FragmentLocationBinding
import com.example.rickandmorty2.presentation.ui.adapters.LocationAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class   LocationFragment : BaseFragment<FragmentLocationBinding, LocationViewModel>(
R.layout.fragment_location
) {
    override val viewModel: LocationViewModel by viewModels()
    override val binding by viewBinding(FragmentLocationBinding::bind)
    private val locationsAdapter = LocationAdapter()

    override fun setupViews() {
        setupAdapter()
    }

    private fun setupAdapter() {

        binding.recyclerview.adapter = locationsAdapter
    }

    override fun setupObserver() {
        subscribeToLocations()
    }

    private fun subscribeToLocations() {
        lifecycleScope.launch {
            viewModel.fetchLocations().collectLatest {
                locationsAdapter.submitData(it)
            }
        }
    }

}