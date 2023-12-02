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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.TechTusQuiz.ui.theme.UnscrambleTheme
import com.example.unscramble.R
@Composable
fun InstructionScreen(navController: NavHostController, onStartClick: () -> Unit) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF00594C))
            .verticalScroll(scrollState)
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.q3_question_ecovitaelogo3),
            contentDescription = "Eco Vitae Logo",
            modifier = Modifier.size(150.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            "Eco Quiz Game",
            style = MaterialTheme.typography.headlineMedium,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )

        Text(
            "Instruction",
            style = MaterialTheme.typography.headlineLarge,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        InstructionText("Become an Eco Master for a chance to win a prize!")

        LevelDescription("Eco Novice", "4 correct")
        LevelDescription("Eco Apprentice", "8 correct")
        LevelDescription("Eco Master", "12 correct")

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = onStartClick,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF0BEE6)),
            modifier = Modifier
                .height(56.dp)
                .fillMaxWidth()
        ) {
            Text("Play", style = MaterialTheme.typography.headlineMedium, color = Color.Black)
        }
    }
}

@Composable
fun InstructionText(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodyLarge,
        color = Color.White,
        fontSize = 20.sp,
        textAlign= TextAlign.Center,
        modifier = Modifier.padding(bottom = 16.dp)
    )
}

@Composable
fun LevelDescription(level: String, criteria: String) {
    Text(
        text = "$level - $criteria",
        style = MaterialTheme.typography.bodyLarge,
        color = Color.White,
        fontSize = 20.sp,
        modifier = Modifier.padding(bottom = 8.dp)
    )
}

@Preview
@Composable
fun InstructionScreenPreview() {
    UnscrambleTheme {
        InstructionScreen(navController = rememberNavController(), onStartClick = {})
    }
}