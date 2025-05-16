package com.devid_academy.salattracker.logic.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devid_academy.salattracker.logic.data.repository.UserRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SplashViewModel(
    private val userRepository: UserRepository
): ViewModel() {
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _showFirstSplash = MutableStateFlow(false)
    val showFirstSplash: StateFlow<Boolean> = _showFirstSplash

    init {
        observeSession()
    }

    fun observeSession() {
        Log.i("SPLASH VIEW MODEL", "observeSession")

        viewModelScope.launch {

            delay(300)
            _isLoading.value = true
            _showFirstSplash.value = true
            delay(1000)
            delay(800)
            _showFirstSplash.value = false
            delay(500)

            userRepository.checkSupabaseSession()

            _isLoading.value = false
        }
    }
}