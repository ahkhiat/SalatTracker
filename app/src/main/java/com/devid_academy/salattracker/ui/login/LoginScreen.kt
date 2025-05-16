package com.devid_academy.salattracker.ui.login

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
import androidx.navigation.NavController
import com.devid_academy.salattracker.ui.reusablecomponents.ScaffoldComposable

@Composable
fun LoginScreen(
    navController: NavController
) {
    LoginContent()
}

@Composable
private fun LoginContent() {
    ScaffoldComposable (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        content = { innerPadding ->

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center

            ){
                Text(
                    text = "Login Screen",
                    color = Color.Black,
                    fontSize = 24.sp
                )
            }

        }
    )
}

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    LoginContent()
}