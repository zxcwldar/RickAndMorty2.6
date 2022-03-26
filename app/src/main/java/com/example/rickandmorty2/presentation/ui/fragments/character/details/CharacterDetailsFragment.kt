package com.example.rickandmorty2.presentation.ui.fragments.character.details

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmorty2.R
import com.example.rickandmorty2.base.BaseFragment
import com.example.rickandmorty2.common.expensions.setImage
import com.example.rickandmorty2.common.resourse.Resource
import com.example.rickandmorty2.databinding.FragmentCharacterDetailsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CharacterDetailsFragment :
    BaseFragment<FragmentCharacterDetailsBinding, CharacterDetailsViewModel>(
        R.layout.fragment_character_details
    ) {
    override val binding by viewBinding(FragmentCharacterDetailsBinding::bind)
    override val viewModel: CharacterDetailsViewModel by viewModels()
    private val args: CharacterDetailsFragmentArgs by navArgs()


    override fun setupViews() {
    }


    override fun setupObserver() {
        subscribeToCharacters()
    }


    private fun subscribeToCharacters() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.fetchSingleCharacter(args.characterId).observe(viewLifecycleOwner) {
                when (it) {
                    is Resource.Loading -> {
                        Log.e("Anime", "Loading ")
                    }

                    is Resource.Error -> {
                        Log.e("Anime", it.message.toString())


                    }
                    is Resource.Success -> {
                        binding.tvCharacter.text = it.data?.name
                        it.data?.image?.let { it1 -> binding.imCharacter.setImage(it1) }
                    }
                }
            }

        }
    }


}