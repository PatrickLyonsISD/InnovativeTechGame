/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.TechTusQuiz


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.TechTusQuiz.SignUp.SignUpScreen
import com.example.TechTusQuiz.login.LoginScreen
import com.example.TechTusQuiz.ui.GameOverScreen
import com.example.TechTusQuiz.ui.GameScreen
import com.example.TechTusQuiz.ui.InstructionScreen
import com.example.TechTusQuiz.ui.QuizViewModel
import com.example.TechTusQuiz.ui.QuizViewModelFactory
import com.example.TechTusQuiz.ui.SoundManager
import com.example.TechTusQuiz.ui.WelcomeScreen
import com.example.TechTusQuiz.ui.WinScreen
import com.example.TechTusQuiz.ui.theme.UnscrambleTheme
import com.example.TechTusQuiz.userProfile.UserProfileViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Create SoundManager and ViewModelFactory
        val soundManager = SoundManager(this)
        val viewModelFactory = QuizViewModelFactory(soundManager)

        setContent {
            UnscrambleTheme {
                // Define NavController here
                val navController = rememberNavController()

                val gameViewModel: QuizViewModel = viewModel(factory = viewModelFactory)


                MyApp(navController, gameViewModel)
            }
        }
    }

    @Composable
    fun MyApp(navController: NavHostController, gameViewModel: QuizViewModel) {
        NavHost(navController = navController, startDestination = "signUpScreen") {
            composable("signUpScreen") {
                SignUpScreen(navController)
            }
            composable("welcomeScreen") {
                WelcomeScreen(navController) {
                    navController.navigate("instructionScreen")
                }
            }
            composable("login") {
                LoginScreen(navController) // SignUp screen, assuming a SignUpViewModel exists
            }
            composable("instructionScreen") {
                InstructionScreen(navController) {
                    navController.navigate("gameScreen")
                }
            }
            composable("gameScreen") {
                GameScreen(navController, gameViewModel)
            }
            composable("gameOverScreen/{score}") { backStackEntry ->
                val score = backStackEntry.arguments?.getString("score")?.toIntOrNull() ?: 0
                GameOverScreen(navController, gameViewModel, score)
            }
            composable("winScreen") {
                val userProfileViewModel = viewModel<UserProfileViewModel>()

                WinScreen(navController, gameViewModel, userProfileViewModel)
            }
            // Add other composables if needed
        }
    }
}
