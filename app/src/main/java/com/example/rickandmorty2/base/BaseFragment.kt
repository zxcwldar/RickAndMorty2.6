package com.example.rickandmorty2.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.viewbinding.ViewBinding
import com.example.rickandmorty2.R




abstract class BaseFragment<Binding : ViewBinding, ViewModel : BaseViewModel>(
    @LayoutRes layoutId: Int
) : Fragment(layoutId) {

    protected abstract val binding: Binding
    protected abstract val viewModel: ViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupViews()
        setupListeners()
        setupObserver()
        setupRequest()
    }

    open fun initialize() {


    }

    open fun setupViews() {

    }

    open fun setupListeners() {
    }


    open fun setupObserver() {

    }

    open fun setupRequest() {

    }
}