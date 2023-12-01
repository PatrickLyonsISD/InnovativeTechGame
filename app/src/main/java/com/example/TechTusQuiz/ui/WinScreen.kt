package com.example.TechTusQuiz.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.TechTusQuiz.userProfile.UserProfileViewModel

@Composable
fun WinScreen(navController: NavHostController, gameViewModel: QuizViewModel, userProfileViewModel: UserProfileViewModel) {
    val statusMessage by userProfileViewModel.statusMessage.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF00594C)), // Adjust the background color as needed
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Congratulations!",
            style = MaterialTheme.typography.headlineLarge,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "You've become an Eco Master!",
            style = MaterialTheme.typography.headlineMedium,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                userProfileViewModel.enterDraw()
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow)
        ) {
            Text("Enter Draw", color = Color.Black)
        }

        Spacer(modifier = Modifier.height(16.dp))

        statusMessage?.let {
            Text(it, color = Color.White)
        }
    }
}