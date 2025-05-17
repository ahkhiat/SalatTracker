package com.devid_academy.salattracker.ui.bootstrap

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.devid_academy.salattracker.logic.enum.AuthentificationStateEnum
import com.devid_academy.salattracker.logic.viewmodel.UserViewModel
import com.devid_academy.salattracker.ui.login.LoginScreen
import com.devid_academy.salattracker.ui.mainscreen.MainScreen
import com.devid_academy.salattracker.ui.splash.SplashScreen
import org.koin.androidx.compose.koinViewModel

@Composable
fun BootstrapComposable() {
    Log.i("BOOTSTRAP COMPOSABLE", "BootstrapComposable")
    val navController = rememberNavController()
    val userViewModel: UserViewModel = koinViewModel()

    val authentificationState = userViewModel.observeUserState().collectAsStateWithLifecycle()
    Log.i("BOOTSTRAP COMPOSABLE", "authentificationState: ${authentificationState.value}")

    when (authentificationState.value) {
        AuthentificationStateEnum.SPLASH -> {
            SplashScreen()
        }
        AuthentificationStateEnum.LOGGED_IN -> {
            AuthenticatedNavHost(navController)
        }
        AuthentificationStateEnum.LOGGED_OUT -> {
            UnauthenticatedNavHost(navController)

            // test only
            // erase when login works
//            AuthenticatedNavHost(navController)

        }
    }
}

@Composable
fun AuthenticatedNavHost(navController: NavHostController) {
    Log.i("BOOTSTRAP COMPOSABLE", "AuthenticatedNavHost")
    NavHost(
        navController = navController,
        startDestination = Screen.Main.route
    ) {
        composable(Screen.Main.route) {
            MainScreen(navController)
        }
    }
}

@Composable
fun UnauthenticatedNavHost(navController: NavHostController) {
    Log.i("BOOTSTRAP COMPOSABLE", "UnauthenticatedNavHost")

    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {
        composable(Screen.Login.route) {
            LoginScreen(navController)
        }
    }
}


sealed class Screen(val route: String) {
    object Login: Screen("login")
    object Register: Screen("register")
    object Main: Screen("main")
}