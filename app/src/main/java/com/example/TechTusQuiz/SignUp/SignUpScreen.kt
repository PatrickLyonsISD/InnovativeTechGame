package com.example.TechTusQuiz.SignUp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(navController: NavController, signUpViewModel: SignUpViewModel = viewModel()) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var signUpMessage by remember { mutableStateOf<String?>(null) }

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
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email", fontSize = 16.sp, color = Color.White) },
            singleLine = true,
            textStyle = LocalTextStyle.current.copy(color = Color.White),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.White,
                unfocusedBorderColor = Color.Gray
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password", fontSize = 16.sp, color = Color.White) },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            textStyle = LocalTextStyle.current.copy(color = Color.White),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.White,
                unfocusedBorderColor = Color.Gray
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("K-Number", fontSize = 16.sp, color = Color.White) },
            singleLine = true,
            textStyle = LocalTextStyle.current.copy(color = Color.White),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.White,
                unfocusedBorderColor = Color.Gray
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                signUpViewModel.signUp(email, password, name) { message ->
                    signUpMessage = message
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF0BEE6)),
            modifier = Modifier.fillMaxWidth()

        ) {
            Text("Sign Up",style = MaterialTheme.typography.headlineMedium, color = Color.Black)
        }
        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { navController.navigate("login") },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF0BEE6)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Login",style = MaterialTheme.typography.headlineMedium, color = Color.Black)
        }

        signUpMessage?.let {
            Spacer(modifier = Modifier.height(8.dp))

            Text(it, color = MaterialTheme.colorScheme.error)
        }
    }
}