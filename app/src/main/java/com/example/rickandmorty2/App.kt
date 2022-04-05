package com.example.rickandmorty2

import android.app.Application
import com.example.rickandmorty2.servicelocator.appDatabaseModule
import com.example.rickandmorty2.servicelocator.networkModule
import com.example.rickandmorty2.servicelocator.repositoryModule
import com.example.rickandmorty2.servicelocator.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger()
            androidContext(this@App)
            modules(networkModule , repositoryModule , viewModelModule, appDatabaseModule)
        }
    }
}
