package com.example.rickandmorty2.presentation.ui.fragments.episode

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
import com.example.rickandmorty2.databinding.FragmentEpisodeBinding
import com.example.rickandmorty2.presentation.ui.adapters.EpisodeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class EpisodeFragment :
    BaseFragment<FragmentEpisodeBinding, EpisodeViewModel>(R.layout.fragment_episode) {
    override val binding by viewBinding(FragmentEpisodeBinding::bind)
    override val viewModel: EpisodeViewModel by viewModels()
    private val episodeAdapter = EpisodeAdapter()
    override fun setupViews() {
        setupAdapter()

    }


    private fun setupAdapter() {
        binding.recyclerview.adapter = episodeAdapter
    }


    override fun setupObserver() {
        subscribeToEpisodes()
    }

    private fun subscribeToEpisodes() {
        lifecycleScope.launch {
            viewModel.fetchEpisodes().collectLatest {
                episodeAdapter.submitData(it)
            }
        }

    }


}