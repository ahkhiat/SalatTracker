package com.devid_academy.salattracker.logic.data.repository

import com.devid_academy.salattracker.logic.data.dto.PrayerDTO
import com.devid_academy.salattracker.logic.data.network.SupabaseClient

class PrayerRepository(
    private val client: SupabaseClient
) {

    suspend fun fetchPrayersList(): List<PrayerDTO> {
        return listOf(
            PrayerDTO(
                id = 1L,
                name = "Fajr",
                order = 1,
                type = "Obligatory"
            ),
            PrayerDTO(
                id = 2L,
                name = "Dhor",
                order = 2,
                type = "Obligatory"
            ),
            PrayerDTO(
                id = 3L,
                name = "Asr",
                order = 3,
                type = "Obligatory"
            ),
            PrayerDTO(
                id = 4L,
                name = "Maghreb",
                order = 4,
                type = "Obligatory"
            ),
            PrayerDTO(
                id = 5L,
                name = "Icha",
                order = 5,
                type = "Obligatory"
            )
        )
    }

}