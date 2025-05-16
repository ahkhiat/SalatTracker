package com.devid_academy.salattracker.logic.viewmodel

import androidx.lifecycle.ViewModel
import com.devid_academy.salattracker.logic.data.repository.UserRepository
import com.devid_academy.salattracker.logic.enum.AuthentificationStateEnum
import kotlinx.coroutines.flow.StateFlow

class UserViewModel(
    private val userRepository: UserRepository
): ViewModel() {
    fun observeUserState(): StateFlow<AuthentificationStateEnum> = userRepository.observeUserState()
}