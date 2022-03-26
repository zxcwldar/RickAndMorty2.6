package com.example.rickandmorty2.presentation.ui.fragments.character
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmorty2.R
import com.example.rickandmorty2.base.BaseFragment
import com.example.rickandmorty2.data.remote.dtos.character.RickAndMortyCharacter
import com.example.rickandmorty2.databinding.FragmentCharacterBinding
import com.example.rickandmorty2.presentation.ui.adapters.CharacterAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CharacterFragment :  BaseFragment<FragmentCharacterBinding, CharacterViewModel>(
R.layout.fragment_character
) {
    override val binding by viewBinding(FragmentCharacterBinding::bind)
    override val viewModel: CharacterViewModel by viewModels()
    private val characterAdapter = CharacterAdapter(this :: onItemClick)

    override fun setupViews() {
        setupAdapter()
    }

    private fun setupAdapter() {
        binding.recyclerview.adapter = characterAdapter
    }


    override fun setupObserver() {
        subscribeToCharacters()
    }

    private fun subscribeToCharacters() {
        lifecycleScope.launch {
            viewModel.fetchCharacters().collectLatest {
                characterAdapter.submitData(it)
            }
        }

    }
    private fun onItemClick(description: RickAndMortyCharacter) {}


}