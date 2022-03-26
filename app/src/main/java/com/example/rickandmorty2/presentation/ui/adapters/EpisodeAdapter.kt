package com.example.rickandmorty2.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty2.data.remote.dtos.episode.RickAndMortyEpisode
import com.example.rickandmorty2.databinding.ItemEpisodeBinding

class EpisodeAdapter :
    PagingDataAdapter<RickAndMortyEpisode, EpisodeAdapter.EpisodeViewHolder>(EpisodesComparator) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder =
        EpisodeViewHolder(
            ItemEpisodeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    inner class EpisodeViewHolder(private val binding: ItemEpisodeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(rickAndMortyEpisode: RickAndMortyEpisode) {

            binding.tvName.text = rickAndMortyEpisode.name
            binding.tvAirDate.text = rickAndMortyEpisode.air_date
            binding.tvEpisode.text = rickAndMortyEpisode.episode


        }

    }

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }

    }

}

object EpisodesComparator : DiffUtil.ItemCallback<RickAndMortyEpisode>() {
    override fun areItemsTheSame(
        oldItem: RickAndMortyEpisode,
        newItem: RickAndMortyEpisode
    ): Boolean {
        return oldItem.id == newItem.id

    }

    override fun areContentsTheSame(
        oldItem: RickAndMortyEpisode,
        newItem: RickAndMortyEpisode
    ): Boolean {
        return oldItem == newItem

    }

}