package com.example.TechTusQuiz.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.unscramble.R


@Composable
fun LoginScreen(navController: NavController, loginViewModel: LoginViewModel = viewModel()) {
    val username by loginViewModel.username.collectAsState()
    val password by loginViewModel.password.collectAsState()
    val isLoading by loginViewModel.isLoading.collectAsState()
    val loginError by loginViewModel.loginError.collectAsState()
    val isSuccessLogin by loginViewModel.isSuccessLogin.collectAsState()

    if (isSuccessLogin) {
        LaunchedEffect(Unit) {
            navController.navigate("welcomeScreen") {
                popUpTo("login") { inclusive = true }
            }
        }
    }

    LoginContent(
        username = username,
        password = password,
        isLoading = isLoading,
        loginError = loginError,
        onUsernameChange = { loginViewModel.onUsernameChange(it) },
        onPasswordChange = { loginViewModel.onPasswordChange(it) },
        onLoginClick = { loginViewModel.login() },
        onSignUpClick = { navController.navigate("signUpScreen") }
    )
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginContent(
    username: String,
    password: String,
    isLoading: Boolean,
    loginError: String?,
    onUsernameChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onLoginClick: () -> Unit,
    onSignUpClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF00594C))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.q3_question_ecovitaelogo3),
            contentDescription = "Eco Vitae Logo",
            modifier = Modifier.size(150.dp)
        )
        if (isLoading) {
            CircularProgressIndicator()
        } else {

            OutlinedTextField(
                value = username,
                onValueChange = onUsernameChange,
                label = { Text(text = "Email", fontSize = 16.sp, color = Color.White) },
                singleLine = true,
                shape = RoundedCornerShape(8.dp),
                textStyle = LocalTextStyle.current.copy(color = Color.White),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.Gray
                )
            )

            Spacer(modifier = Modifier.height(8.dp))


            OutlinedTextField(
                value = password,
                onValueChange = onPasswordChange,
                label = { Text("Password", fontSize = 16.sp, color = Color.White) },
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                shape = RoundedCornerShape(8.dp),
                textStyle = LocalTextStyle.current.copy(color = Color.White),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.Gray
                )
            )

            Spacer(modifier = Modifier.height(16.dp))


            Button(
                onClick = onLoginClick,
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF0BEE6)
                )
            ) {
                Text("Login", style = MaterialTheme.typography.headlineMedium, color = Color.Black)
            }

            Spacer(modifier = Modifier.height(8.dp))

            loginError?.let {
                Spacer(modifier = Modifier.height(8.dp))
                Text(it, color = Color.Red)
            }
        }
    }
}