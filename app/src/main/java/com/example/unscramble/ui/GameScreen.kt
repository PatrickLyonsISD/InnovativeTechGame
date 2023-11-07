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
package com.example.unscramble.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.unscramble.data.Question
import com.example.unscramble.ui.theme.UnscrambleTheme
import androidx.compose.runtime.livedata.observeAsState

@Composable
fun GameScreen(gameViewModel: QuizViewModel= viewModel()) {
    val currentQuestion by gameViewModel.currentQuestion.observeAsState()
    val currentScore by gameViewModel.currentScore.observeAsState(0)
    val isGameOver by gameViewModel.isGameOver.observeAsState(false)


    Scaffold(

    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            if (isGameOver) {
                GameOverDialog(score = currentScore, onDismiss = {
                    gameViewModel.resetGame()
                })
            } else {
                currentQuestion?.let {
                    QuestionContent(question = it, onAnswerSelected = { answerIndex ->
                        gameViewModel.submitAnswer(answerIndex)
                    })
                }
                ScoreDisplay(score = currentScore)
            }
        }
    }
}


@Composable
    fun GameOverDialog(score: Int, onDismiss: () -> Unit) {
        AlertDialog(
            onDismissRequest = { /* Do nothing to prevent dismiss */ },
            title = { Text("Game Over") },
            text = { Text("Your final score is $score") },
            confirmButton = {
                Button(onClick = onDismiss) {
                    Text("Play Again")
                }
            }
        )
    }

@Composable
fun QuestionScreen(question: Question?, score: Int, onAnswerSelected: (Int) -> Unit) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        question?.let {
            QuestionContent(question = it, onAnswerSelected = onAnswerSelected)
        }
        ScoreDisplay(score = score)
    }
}

    @Composable
    fun QuestionContent(question: Question, onAnswerSelected: (Int) -> Unit) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = question.text, style = MaterialTheme.typography.displayMedium)

            Spacer(modifier = Modifier.height(20.dp))

            question.options.forEachIndexed { index, option ->
                Button(
                    onClick = { onAnswerSelected(index) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Text(text = option)
                }
            }
        }
    }

    @Composable
    fun ScoreDisplay(score: Int) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Score: $score")
        }
    }





@Composable
@Preview
fun GameScreenPreview() {
    UnscrambleTheme {
        GameScreen()
    }
}