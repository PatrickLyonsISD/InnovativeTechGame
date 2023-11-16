
package com.example.TechTusQuiz.ui

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
import com.example.TechTusQuiz.data.Option
import com.example.unscramble.frame5.Background

@Composable
fun GameScreen(gameViewModel: QuizViewModel= viewModel()) {
    val currentQuestion by gameViewModel.currentQuestion.observeAsState()
    val currentScore by gameViewModel.currentScore.observeAsState(0)
    val isGameOver by gameViewModel.isGameOver.observeAsState(false)
    val selectedAnswerExplanation by gameViewModel.selectedAnswerExplanation.observeAsState()

    Scaffold {
        Background()

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
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
            selectedAnswerExplanation?.let { explanation ->
                ExplanationDialog(explanation, onDismiss = { gameViewModel.proceedToNextQuestion() })
            }
        }
        ScoreDisplay(score = currentScore)
    }
}

@Composable
fun QuizContent(question: Question, onAnswerSelected: (Int) -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "GAME TITLE",
            style = MaterialTheme.typography.displaySmall,
            color = Color.Red,
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = question.text,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(8.dp),
            color=Color.White
        )
        Spacer(modifier = Modifier.height(32.dp))
        AnswerGrid(question = question, onAnswerSelected = onAnswerSelected)

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
        colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
        modifier = Modifier.padding(8.dp)
    ) {
        //Text(text = answer, color = Color.White)
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
        Text(text = question.text,
            style = MaterialTheme.typography.displayMedium)
        Spacer(modifier = Modifier.height(20.dp))

        question.options.forEachIndexed { index, option ->
            Button(
                onClick = { onAnswerSelected(index) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                //Text(text = option)
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