package com.example.rickandmorty2.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty2.base.BaseDiffUtil
import com.example.rickandmorty2.data.remote.dtos.location.RickAndMortyLocation
import com.example.rickandmorty2.databinding.ItemLocationBinding

class LocationAdapter :
    ListAdapter<RickAndMortyLocation, LocationAdapter.LocationsViewHolder>(BaseDiffUtil()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationsViewHolder =
        LocationsViewHolder(
            ItemLocationBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )


    override fun onBindViewHolder(holder: LocationsViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }

    }


    class LocationsViewHolder(private val binding: ItemLocationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(rickAndMortyLocation: RickAndMortyLocation) {
            binding.tvName.text = rickAndMortyLocation.name
            binding.tvType.text = rickAndMortyLocation.type
            binding.tvDimension.text = rickAndMortyLocation.dimension

        }


    }
}


