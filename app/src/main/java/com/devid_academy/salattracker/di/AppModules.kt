package com.devid_academy.salattracker.di

import com.devid_academy.salattracker.logic.data.network.SupabaseClient
import com.devid_academy.salattracker.logic.data.repository.PrayerRepository
import com.devid_academy.salattracker.logic.data.repository.UserRepository
import com.devid_academy.salattracker.logic.viewmodel.MainViewModel
import com.devid_academy.salattracker.logic.viewmodel.SplashViewModel
import com.devid_academy.salattracker.logic.viewmodel.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val databaseModule = module {
    single { SupabaseClient() }
    single { SupabaseClient().client }
    single { UserRepository(get()) }
    single { PrayerRepository(get()) }
}


val viewModelsModule = module {
    viewModel { UserViewModel(get()) }
    viewModel { SplashViewModel(get()) }
    viewModel { MainViewModel(get()) }
}