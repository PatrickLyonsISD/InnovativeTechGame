
package com.example.TechTusQuiz.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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

    //colours
    val darkGreen = Color(0xFF00594C)


    Scaffold {
        Column(modifier = Modifier
            .fillMaxSize()
            .background(darkGreen)
        ) {
            TopBar(currentQuestionIndex = currentQuestionIndex, currentScore = currentScore)
            Spacer(modifier = Modifier.height(24.dp))

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
            BottomButtons(gameViewModel = gameViewModel)

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
        // Replace with your logo image
        Image(
            painter = painterResource(id = R.drawable.android_small_1_game_logo_1), // Replace with your logo resource
            contentDescription = "Logo"
        )

        // Displaying question number and score beside each other
        Row(verticalAlignment = Alignment.CenterVertically) { // Correct parameter for inner Row
            Text("Question: $currentQuestionIndex",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(end = 8.dp)
            )

            Text("Score: $currentScore",
                    style = MaterialTheme.typography.headlineMedium
            )
        }
    }
}

@Composable
fun QuizContent(question: Question, onAnswerSelected: (Int) -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        // Consistent background and text styling for the question
        QuestionBox(question = question.text)
        Spacer(modifier = Modifier
            .height(70.dp)
            .fillMaxWidth()
        )

        // Consistently styled answer buttons
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
fun QuestionBox(question: String) {
    val pinkColor = Color(0xFFF0BEE6) // Using consistent color theme
    val scrollState = rememberScrollState()

    BoxWithConstraints(
        modifier = Modifier
            .background(pinkColor)
            .padding(8.dp)
    ) {
        val maxHeight = maxHeight * 0.3f // Adjust the fraction as needed

        Box(
            modifier = Modifier
                .heightIn(max = maxHeight)
                .verticalScroll(scrollState)
        ) {
            Text(
                text = question,
                style = MaterialTheme.typography.headlineMedium,
                color = Color.Black
            )
        }
    }
}
@Composable
fun AnswerButton(answer: Option, onClick: () -> Unit) {
    val tusGold = Color(0xFFDAA520) // Example color, replace with actual

    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = tusGold),
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = answer.text,
            style = MaterialTheme.typography.headlineMedium,
            color = Color.White
        )
    }
}

@Composable
fun BottomButtons(gameViewModel: QuizViewModel) {
    val tusGold = Color(0xFFDAA520) // Example color, replace with actual

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Button(
            onClick = { /* TODO: Handle Exit action */ },
            colors = ButtonDefaults.buttonColors(containerColor = tusGold),
            modifier = Modifier
                .weight(1f)
                .padding(end = 8.dp) // Add padding to the end of the first button
        ) {
            Text("Exit",
                style = MaterialTheme.typography.headlineMedium
                )
        }

        Button(
            onClick = { gameViewModel.resetGame() },
            colors = ButtonDefaults.buttonColors(containerColor = tusGold),
            modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp) // Add padding to the start of the second button
        ) {
            Text("Restart",
                    style = MaterialTheme.typography.headlineMedium
            )
        }
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