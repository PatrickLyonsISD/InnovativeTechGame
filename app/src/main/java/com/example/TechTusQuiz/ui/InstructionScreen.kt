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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.TechTusQuiz.ui.theme.UnscrambleTheme
import com.example.unscramble.R
@Composable
fun InstructionScreen(navController: NavHostController, onStartClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF00594C))
            .padding(50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.q3_question_ecovitaelogo3),
            contentDescription = "Eco Vitae Logo",
            modifier = Modifier.size(
                width = 120.dp,
                height = 120.dp
            )
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Eco Quiz Game",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.White,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        )

        Text(
            text = "Instruction",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.White,
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Become an Eco Master",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.White,
            fontSize = 20.sp,
            fontStyle = FontStyle.Normal
        )


        Text(
            text = "for a chance to win a prize!",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.White,
            fontSize = 20.sp,
            fontStyle = FontStyle.Normal
        )
        Spacer(modifier = Modifier.height(16.dp))


        Text(
            text = " Eco Novice",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.White,
            fontSize = 20.sp,
            fontStyle = FontStyle.Normal
        )


        Text(
            text = "4 correct",
            style = MaterialTheme.typography.bodyLarge,
            fontSize = 20.sp,
            fontStyle = FontStyle.Normal
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Eco Apprentice",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.White,
            fontSize = 20.sp,
            fontStyle = FontStyle.Normal
        )

        Text(
            text = "8 correct",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.White,
            fontSize = 20.sp,
            fontStyle = FontStyle.Normal
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = " Eco Master",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.White,
            fontSize = 20.sp,
            fontStyle = FontStyle.Normal
        )
        Text(
            text = "12 correct",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.White,
            fontSize = 20.sp,
            fontStyle = FontStyle.Normal
        )


        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = onStartClick,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF0BEE6)),
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(60.dp)
        ) {
            Text(
                text = "Play",
                style = MaterialTheme.typography.headlineMedium,
                color = Color.Black
            )
        }
    }
}
@Preview
@Composable
fun InstructionScreenPreview() {
    UnscrambleTheme {
        val navController = rememberNavController()
        InstructionScreen(navController = navController, onStartClick = {})
    }
}