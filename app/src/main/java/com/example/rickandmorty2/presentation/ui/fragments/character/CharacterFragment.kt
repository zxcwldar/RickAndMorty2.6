package com.example.rickandmorty2.presentation.ui.fragments.character

import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmorty2.R
import com.example.rickandmorty2.base.BaseFragment
import com.example.rickandmorty2.common.expensions.submitData
import com.example.rickandmorty2.databinding.FragmentCharacterBinding
import com.example.rickandmorty2.presentation.ui.adapters.CharacterAdapter
import com.example.rickandmorty2.utils.PaginationScrollListener
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterFragment : BaseFragment<FragmentCharacterBinding, CharacterViewModel>(
    R.layout.fragment_character
) {
    override val binding by viewBinding(FragmentCharacterBinding::bind)
    override val viewModel: CharacterViewModel by viewModel()
    private val characterAdapter = CharacterAdapter(this::onItemClick)

    override fun setupViews() {
        setupAdapter()
    }

    override fun setupObserver() {
        subscribeToCharacters()
        subscribeToCharactersLocale()

    }

    private fun setupAdapter() = with(binding.recyclerview) {
        val linearLayoutManager = LinearLayoutManager(context)
        layoutManager = linearLayoutManager
        adapter = characterAdapter

        addOnScrollListener(object :
            PaginationScrollListener(linearLayoutManager, {
                if (isOnline()) viewModel.fetchCharacter() else null
            }) {
            override fun isLoading() = viewModel.isLoading
        })
    }

    private fun subscribeToCharacters() {
        viewModel.characterState.observe(viewLifecycleOwner) {
            characterAdapter.submitData(it.results)
        }
    }

    private fun subscribeToCharactersLocale() {
        viewModel.characterLocaleState.observe(viewLifecycleOwner) {
            characterAdapter.submitData(it)
        }
    }

    override fun setupRequest() {
        if (viewModel.characterState.value == null && isOnline()) viewModel.fetchCharacter()
        else viewModel.getCharacters()
    }

    fun isOnline(): Boolean {
        val cm = requireActivity().getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = cm.activeNetworkInfo
        return netInfo != null && netInfo.isConnectedOrConnecting
    }

    private fun onItemClick(id: Int) {
        findNavController().navigate(
            CharacterFragmentDirections.actionCharactersFragmentToCharacterDetailsFragment(
                id
            )
        )
    }
}