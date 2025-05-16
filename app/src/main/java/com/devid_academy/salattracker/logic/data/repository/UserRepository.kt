package com.devid_academy.salattracker.logic.data.repository

import android.util.Log
import com.devid_academy.salattracker.logic.enum.AuthentificationStateEnum
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.status.SessionStatus
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class UserRepository(
    private val client: SupabaseClient
) {
    private val userState = MutableStateFlow(AuthentificationStateEnum.SPLASH)
    fun observeUserState(): StateFlow<AuthentificationStateEnum> = userState

    suspend fun checkSupabaseSession() {
        client.auth.sessionStatus.collect {
            Log.i("USER REPOSITORY", "checkSupabaseSession: ${it}")
            when (it) {
                is SessionStatus.Authenticated -> userState.value =
                    AuthentificationStateEnum.LOGGED_IN

                is SessionStatus.NotAuthenticated -> userState.value =
                    AuthentificationStateEnum.LOGGED_OUT

                is SessionStatus.Initializing -> userState.value = AuthentificationStateEnum.SPLASH
                is SessionStatus.RefreshFailure -> userState.value =
                    AuthentificationStateEnum.LOGGED_OUT

            }
        }
    }
}