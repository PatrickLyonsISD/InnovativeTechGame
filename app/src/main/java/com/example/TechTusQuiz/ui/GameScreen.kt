
package com.example.TechTusQuiz.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import com.example.TechTusQuiz.data.Question
import com.example.TechTusQuiz.ui.theme.UnscrambleTheme
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.TechTusQuiz.data.Option
import com.example.unscramble.R
import com.google.relay.compose.RelayVector


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun GameScreen(gameViewModel: QuizViewModel = viewModel()) {
    val currentQuestion by gameViewModel.currentQuestion.observeAsState()
    val currentScore by gameViewModel.currentScore.observeAsState(0)
    val isGameOver by gameViewModel.isGameOver.observeAsState(false)
    val explanation by gameViewModel.selectedAnswerExplanation.observeAsState()
    val currentQuestionIndex by gameViewModel.currentQuestionIndex.observeAsState(0)

    Scaffold {
        Column(modifier = Modifier.fillMaxSize()) {
            // Top Row with Logo, Question Number, and Score
            TopBar(currentQuestionIndex = currentQuestionIndex, currentScore = currentScore)


            // Spacer for additional space between the top bar and the question
            Spacer(modifier = Modifier.height(24.dp))

            // Main Content
            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp),
                contentAlignment = Alignment.TopCenter
            )

            {
                if (isGameOver) {
                    GameOverDialog(score = currentScore, onDismiss = { gameViewModel.resetGame() })
                } else {
                    // Main quiz content
                    currentQuestion?.let { question ->
                        QuizContent(question = question, onAnswerSelected = { answerIndex ->
                            gameViewModel.submitAnswer(answerIndex)
                        })
                    }
                }

                // Explanation dialog
                explanation?.let { explanationText ->
                    ExplanationDialog(
                        explanation = explanationText,
                        onDismiss = { gameViewModel.proceedToNextQuestion() })
                }

            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = { /* TODO: Handle Exit action */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red) // change to tus gold
                ) {
                    Text("Exit")
                }
                Button(
                    onClick = { gameViewModel.resetGame() },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red) // change to tus gold
                ) {
                    Text("Restart")
                }
            }
        }
    }
}


@Composable
fun TopBar(currentQuestionIndex: Int, currentScore: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Logo on the left
        Text("Logo Here")

        // Question number and Score on the right
        Column(horizontalAlignment = Alignment.End) {
            Text("Question: $currentQuestionIndex")
            Text("Score: $currentScore")
        }
    }
}

@Composable
fun QuizContent(question: Question, onAnswerSelected: (Int) -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        val pinkColor = Color(0xFFFFC0CB)

        Box(
            modifier = Modifier
                .background(pinkColor)
                .padding(8.dp)
        ) {
            Text(
                text = question.text,
                style = MaterialTheme.typography.headlineMedium,
                color = Color.Black
            )
        }
        Spacer(modifier = Modifier.height(136.dp))

        // Answers in a vertical list
        question.options.forEachIndexed { index, option ->
            AnswerButton(answer = option, onClick = { onAnswerSelected(index) })
        }
    }
}


@Composable
fun AnswerGrid(question: Question, onAnswerSelected: (Int) -> Unit) {

    Grid(items = question.options, numColumns = 2) { answer, index ->
        AnswerButton(answer) { onAnswerSelected(index) }
    }
}

@Composable
fun <T> Grid(items: List<T>, numColumns: Int, content: @Composable (item: T, index: Int) -> Unit) {
    Column {
        for (i in items.indices step numColumns) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                for (j in 0 until numColumns) {
                    if (i + j < items.size) {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .aspectRatio(1f),
                            contentAlignment = Alignment.Center
                        ) {
                            content(items[i + j], i + j)
                        }
                    } else {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
        }
    }
}

@Composable
fun AnswerButton(answer: Option, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        //change to gold get #code in figma
        colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
        modifier = Modifier.padding(8.dp)
    ) {
        Text(
            text = answer.text, // Directly use the text property of Option
            color = Color.White
        )
    }
}


@Composable
fun ScoreDisplay(score: Int) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.Yellow)
            .padding(16.dp)
    ){
        Text(
            text = "Score: $score")
    }
}




@Composable
fun GameOverDialog(score: Int, onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = { onDismiss() },
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
fun ExplanationDialog(explanation: String, onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = { /* Do nothing, require explicit dismissal */ },
        title = { Text("Explanation") },
        text = { Text(explanation) },
        confirmButton = {
            Button(onClick = onDismiss) {
                Text("OK")
            }
        }
    )
}


@Composable
fun QuestionContent(question: Question, onAnswerSelected: (Int) -> Unit) {
    Column {
        Text(
            text = question.text,
            style = MaterialTheme.typography.displayMedium
        )
        Spacer(modifier = Modifier.height(20.dp))

        question.options.forEachIndexed { index, option ->
            Button(
                onClick = { onAnswerSelected(index) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(text = option.text) // Un-comment and use the option text here
            }
        }
    }
}




@Composable
@Preview
fun GameScreenPreview() {
    UnscrambleTheme {
        GameScreen()
    }
}