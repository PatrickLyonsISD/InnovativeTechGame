package com.example.TechTusQuiz.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.TechTusQuiz.ui.theme.UnscrambleTheme
import com.example.unscramble.R

@Composable
fun WelcomeScreen(navController: NavHostController, onStartClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF00594C))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Eco Vitae logo
        Image(
            painter = painterResource(id = R.drawable.q3_question_ecovitaelogo3),
            contentDescription = "Eco Vitae Logo",
            modifier = Modifier.size(width = 150.dp, height = 250.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))


        Text(
            text = "Created by",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(16.dp))


        Image(
            painter = painterResource(id = R.drawable.start_screen_420_tech_tus11_logo_1),
            contentDescription = "Team Logo",
            modifier = Modifier.size(width = 250.dp, height = 250.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Start button
        Button(
            onClick = onStartClick,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF0BEE6)),
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
                .height(56.dp)
        ) {
            Text(
                text = "Start",
                style = MaterialTheme.typography.headlineMedium,
                color = Color.Black
            )
        }
    }
}
@Preview
@Composable
fun WelcomeScreenPreview() {
    UnscrambleTheme {
        val navController = rememberNavController()
        WelcomeScreen(navController = navController, onStartClick = {})
    }
}