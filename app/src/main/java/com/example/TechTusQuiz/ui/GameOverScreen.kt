package com.example.TechTusQuiz.ui


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.unscramble.R
import com.example.unscramble.frame27.inter
import com.google.relay.compose.CrossAxisAlignment
import com.google.relay.compose.MainAxisAlignment
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayContainerArrangement
import com.google.relay.compose.RelayContainerScope
import com.google.relay.compose.RelayImage
import com.google.relay.compose.RelayText
import com.google.relay.compose.RelayVector
import com.google.relay.compose.relayDropShadow

/**
 * GameOver Screen
 *
 * This composable was generated from the UI Package 'frame_27'.
 * Generated code; do not edit directly
 */
@Composable
fun GameOverScreen(navController: NavHostController, gameViewModel: QuizViewModel, finalScore: Int) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF00594C)), // Background color
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Logo at the top
        Image(
            painter = painterResource(id = R.drawable.q3_question_ecovitaelogo3),
            contentDescription = "Logo",
            modifier = Modifier.size(150.dp) // Adjust the size as needed
        )

        // Spacing between logo and text
        Spacer(modifier = Modifier.height(32.dp))

        // Box with "Thanks for playing" message and score
        Box(
            modifier = Modifier
                .background(Color(0xFFa39461), RoundedCornerShape(8.dp)) // White box with rounded corners
                .padding(16.dp)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Thanks for Playing!",
                    style = MaterialTheme.typography.headlineMedium,
                    color = Color.Black
                )
                Text(
                    text = "Your Final Score: $finalScore",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Black
                )
            }
        }

        // Spacing between box and button
        Spacer(modifier = Modifier.height(24.dp))

        // Play Again button
        Button(
            onClick = {
                gameViewModel.resetGame()
                navController.navigate("gameScreen") {
                    popUpTo("gameScreen") { inclusive = true }
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF0BEE6)) // Adjust the color as needed
        ) {
            Text(
                text = "Play Again",
                style = MaterialTheme.typography.headlineMedium,
                color = Color.Black
            )
        }
    }
}
@Preview
@Composable
private fun GameOverScreenPreview() {
    val navController = rememberNavController()

    // Mock ViewModel
    val mockViewModel = QuizViewModel()

    // Mock Score
    val mockScore = 10 // Example score

    GameOverScreen(navController, mockViewModel, mockScore)
}