package com.example.TechTusQuiz.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.TechTusQuiz.userProfile.UserProfileViewModel
import com.example.unscramble.R // Import your image resources

@Composable
fun WinScreen(navController: NavHostController, gameViewModel: QuizViewModel, userProfileViewModel: UserProfileViewModel) {
    val statusMessage by userProfileViewModel.statusMessage.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF00594C)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.q3_question_ecovitaelogo3),
            contentDescription = "Eco Vitae Logo",
            modifier = Modifier.size(width = 150.dp, height = 250.dp)
        )


        Image(
            painter = painterResource(id = R.drawable.winscreenimage_220x220_transp),
            contentDescription = "Action Campaign Image",
            modifier =Modifier.size(width = 150.dp, height = 250.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))


        Text(
            text = "Congratulations!",
            style = MaterialTheme.typography.headlineLarge,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(8.dp))


        Text(
            text = "You have become an Eco Master!\n\nThank you for playing the Eco Vitae game.\n\nYou are eligible to enter draw for a chance to win a prize!",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.White,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))


        Button(
            onClick = { userProfileViewModel.enterDraw() },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF0BEE6)) // Changed color
        ) {
            Text("Enter Draw", color = Color.Black)
        }

        Spacer(modifier = Modifier.height(16.dp))
        statusMessage?.let {
            Text(it, color = Color.White)
        }
    }
}
