package com.devid_academy.salattracker.ui.splash

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.devid_academy.salattracker.logic.viewmodel.SplashViewModel
import com.devid_academy.salattracker.ui.reusablecomponents.ScaffoldComposable
import org.koin.androidx.compose.koinViewModel

@Composable
fun SplashScreen() {
    val viewModel: SplashViewModel = koinViewModel()
    SplashContent()
}

@Composable
private fun SplashContent() {
    ScaffoldComposable (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)
        ,
        content = { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = "Splash Screen",
                    color = Color.Black,
                    fontSize = 24.sp
                )
            }


        }
    )



}

@Preview(showBackground = true)
@Composable
private fun SplashScreenPreview() {
    SplashContent()
}