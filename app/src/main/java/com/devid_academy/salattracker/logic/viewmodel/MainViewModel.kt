package com.devid_academy.salattracker.logic.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devid_academy.salattracker.logic.data.dto.PrayerDTO
import com.devid_academy.salattracker.logic.data.repository.PrayerRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
    private val prayerRepository: PrayerRepository
) : ViewModel() {

    private val _prayersList = MutableStateFlow<List<PrayerDTO>>(emptyList())
    val prayersList: StateFlow<List<PrayerDTO>> = _prayersList.asStateFlow()

    init {
        fetchPrayersList()
    }

    fun fetchPrayersList() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _prayersList.value = prayerRepository.fetchPrayersList()
            }
        }
    }

}