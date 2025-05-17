package com.devid_academy.salattracker.ui.login

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.devid_academy.salattracker.R
import com.devid_academy.salattracker.logic.viewmodel.LoginViewModel
import com.devid_academy.salattracker.ui.bootstrap.Screen
import com.devid_academy.salattracker.ui.reusablecomponents.InputFormTextField
import com.devid_academy.salattracker.ui.reusablecomponents.ScaffoldComposable
import org.koin.androidx.compose.koinViewModel

@Composable
fun LoginScreen(
    navController: NavController
) {
    val viewModel: LoginViewModel = koinViewModel()

    LoginContent(
        onLogin = { email, password ->
            viewModel.loginUser(
                email = email,
                password = password
            )
        },
        onNavigate = {
            navController.navigate(Screen.Register.route)
        }
    )
}

@Composable
fun LoginContent(
    onLogin: (
        email: String,
        password: String) -> Unit,
    onNavigate: () -> Unit
) {
    var emailForm by remember { mutableStateOf("") }
    var passwordForm by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .width(300.dp)
                .align(Alignment.TopCenter)
                .padding(top = 100.dp)
        ) {
            Text(
                text = stringResource(R.string.register_et_email_label),
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            )
            InputFormTextField(
                value = emailForm,
                onValueChange = { emailForm = it },
                label = stringResource(R.string.register_et_email),
                keyboardType = KeyboardType.Email
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = stringResource(R.string.register_et_password_label),
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            )
            InputFormTextField(
                value = passwordForm,
                onValueChange = { passwordForm = it },
                label = stringResource(R.string.register_et_password),
                visualTransformation = true
            )
        }
        Text(
            text = stringResource(R.string.not_registered),
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 150.dp)
                .clickable {
                    onNavigate()
                }
        )
        Button(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 30.dp),
            onClick = {
                onLogin(
                    emailForm,
                    passwordForm
                )
                Log.d("LOGIN BUTTON", "Email : '$emailForm', Password : '$passwordForm'")
            }
        ) {
            Text(
                text = stringResource(R.string.button_login),
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    LoginContent(
        onLogin = {_,_ -> },
        onNavigate = {}
    )
}