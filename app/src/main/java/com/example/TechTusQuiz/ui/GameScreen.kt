
package com.example.TechTusQuiz.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Canvas
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.TechTusQuiz.data.Question
import com.example.TechTusQuiz.ui.theme.UnscrambleTheme
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.TechTusQuiz.data.Option
import com.example.TechTusQuiz.data.UserProgress
import com.example.unscramble.R
import com.google.relay.compose.RelayVector


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun GameScreen(navController: NavController, gameViewModel: QuizViewModel) {
    val currentQuestion by gameViewModel.currentQuestion.observeAsState()
    val currentScore by gameViewModel.currentScore.observeAsState(0)
    val isGameOver by gameViewModel.isGameOver.observeAsState(false)
    val explanation by gameViewModel.selectedAnswerExplanation.observeAsState()
    val currentQuestionIndex by gameViewModel.currentQuestionIndex.observeAsState(0)
    val userProgress by gameViewModel.userProgress.observeAsState()
    var showEcoNoviceDialog by remember { mutableStateOf(false) }
    var showEcoApprenticeDialog by remember { mutableStateOf(false) }
    var showEcoMasterDialog by remember { mutableStateOf(false) }
    val explanationText = explanation
    val explanationImage= explanation

    LaunchedEffect(userProgress) {
        when (userProgress) {
            UserProgress.Eco_Novice -> showEcoNoviceDialog = true
            UserProgress.Eco_Apprentice -> showEcoApprenticeDialog = true
            UserProgress.Eco_Master -> showEcoMasterDialog = true
            else -> { /* Continue the quiz */ }
        }
    }
    if (showEcoNoviceDialog) {
        EcoNoviceDialog(onDismiss = { showEcoNoviceDialog = false })
    }
    if (showEcoApprenticeDialog) {
        EcoApprenticeDialog(onDismiss = { showEcoApprenticeDialog = false })
    }
    if (showEcoMasterDialog) {
        EcoMasterDialog(onDismiss = { showEcoMasterDialog = false })
    }


    if (isGameOver) {
        LaunchedEffect(Unit) {
            navController.navigate("gameOverScreen/$currentScore")
        }
    }

    if (gameViewModel.isGameOver.value == true && gameViewModel.userProgress.value == UserProgress.Eco_Master) {
        LaunchedEffect(Unit) {
            navController.navigate("winScreen")
        }
    }


    Scaffold {
        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF00594C))
        ) {
            TopBar(currentQuestionIndex = currentQuestionIndex, currentScore = currentScore)
            Spacer(modifier = Modifier.height(24.dp))

            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp),
                contentAlignment = Alignment.TopCenter
            ) {
                currentQuestion?.let { question ->
                    QuizContent(question = question,
                        onAnswerSelected = {answerIndex -> gameViewModel.submitAnswer(answerIndex)},
                        progress = calculateProgress(gameViewModel)
                    )
                }
            }


            BottomButtons(navController = navController, gameViewModel = gameViewModel)


        }

        if (!explanationText.isNullOrEmpty()) {
            val explanationImageResId = currentQuestion?.explanationImage ?: R.drawable.q2_question_factory_1
            ExplanationDialog(
                explanation = explanationText,
                explanationImage = explanationImageResId,
                isCorrect = gameViewModel.isLastAnswerCorrect.value ?: false,
                onDismiss = {
                    gameViewModel.resetExplanation()
                    if (!isGameOver) {
                        gameViewModel.proceedToNextQuestion()
                    }
                }
            )
        }
    }
}

fun calculateProgress(gameViewModel: QuizViewModel): Float {
    val totalQuestions = gameViewModel.totalQuestions
    val correctAnswers = gameViewModel.currentScore.value ?: 0

    return if (totalQuestions > 0) {
        correctAnswers.toFloat() / totalQuestions
    } else 0f
}


@Composable
fun TopBar(currentQuestionIndex: Int, currentScore: Int) {
    val displayedQuestionIndex = currentQuestionIndex + 1
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

      Image(
          painter = painterResource(id =R.drawable.q3_question_ecovitaelogo3),
            contentDescription = "Logo"
        )


        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Question:$displayedQuestionIndex",
                style = MaterialTheme.typography.headlineMedium,
                color = Color.White,
                modifier = Modifier.padding(end = 8.dp)
            )

            Text("Score:$currentScore",
                    style = MaterialTheme.typography.headlineMedium,
                color = Color.White
            )
        }
    }
}

@Composable
fun BatteryProgressBar(progress: Float) {
    val batteryWidth = 50.dp
    val batteryHeight = 100.dp
    val capHeight = 10.dp
    val capWidth = 20.dp
    val cornerRadius = 4.dp

    Box(
        modifier = Modifier
            .width(batteryWidth)
            .height(batteryHeight + capHeight)
            .padding(16.dp),
        contentAlignment = Alignment.BottomCenter
    ) {

        Canvas(modifier = Modifier.fillMaxSize()) {
            val capRect = Rect(
                offset = Offset((size.width - capWidth.toPx()) / 2, 0f),
                size = Size(capWidth.toPx(), capHeight.toPx())
            )
            val bodyRect = Rect(
                offset = Offset(0f, capHeight.toPx()),
                size = Size(size.width, size.height - capHeight.toPx())
            )

            drawRoundRect(
                color = Color.Gray,
                size = bodyRect.size,
                topLeft = bodyRect.topLeft,
                cornerRadius = CornerRadius(cornerRadius.toPx())
            )
            drawRect(
                color = Color.Gray,
                topLeft = capRect.topLeft,
                size = capRect.size
            )
        }


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(batteryHeight * progress)
                .background(Color.Green, shape = RoundedCornerShape(cornerRadius))
        )
    }
}

@Composable
fun QuizContent(question: Question, onAnswerSelected: (Int) -> Unit, progress: Float) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            Row(
                verticalAlignment = Alignment.Top,
                modifier = Modifier.padding(8.dp)
            ) {

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(8.dp)
                        .heightIn(max = 250.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    Text(
                        text = question.text,
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Black
                    )
                }


                Image(
                    painter = painterResource(id = question.questionImage),
                    contentDescription = "Question Image",
                    modifier = Modifier.size(100.dp)
                )
                BatteryProgressBar(progress = progress)
            }
        }


        items(question.options.size) { index ->
            AnswerButton(
                answer = question.options[index],
                onClick = { onAnswerSelected(index) }
            )
        }
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
    val pinkColor = Color(0xFFFFFF)
    val scrollState = rememberScrollState()

    BoxWithConstraints(
        modifier = Modifier
            .background(pinkColor)
            .padding(8.dp)
    ) {
        val maxHeight = maxHeight * 0.3f

        Box(
            modifier = Modifier
                .heightIn(max = maxHeight)
                .verticalScroll(scrollState)
        ) {
            Text(
                text = question,
                style = MaterialTheme.typography.headlineSmall,
                color = Color.White
            )
        }
    }
}
@Composable
fun AnswerButton(answer: Option, onClick: () -> Unit) {
    val tusGold = Color(0xFFa39461)

    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = tusGold),
        modifier = Modifier
            .padding(8.dp)  // Reduced padding
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = answer.text,
                style = MaterialTheme.typography.bodyLarge,  // Adjusted text style
                color = Color.Black,
                textAlign = TextAlign.Start
            )
        }
    }
}

@Composable
fun BottomButtons(navController: NavController, gameViewModel: QuizViewModel) {
    val tusGold = Color(0xFFF0BEE6)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Button(
            onClick = {
                gameViewModel.resetGame()
                navController.navigate("welcomeScreen") {

                    popUpTo("welcomeScreen") { inclusive = true }
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = tusGold),
            modifier = Modifier
                .weight(1f)
                .padding(end = 8.dp)
        ) {
            Text("Exit", style = MaterialTheme.typography.headlineMedium, color = Color.Black)
        }

        Button(
            onClick = { gameViewModel.resetGame() },
            colors = ButtonDefaults.buttonColors(containerColor = tusGold),
            modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp)
        ) {
            Text("Restart", style = MaterialTheme.typography.headlineMedium, color = Color.Black)
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
fun ExplanationDialog(explanation: String, explanationImage: Int, isCorrect: Boolean, onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = { /* Do nothing, require explicit dismissal */ },
        title = { Text(if (isCorrect) "Correct!" else "Incorrect") },
        text = {
            Column {
                Image(painter = painterResource(id = explanationImage), contentDescription = "Explanation Image")
                Text(explanation)
            }
        },
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
                Text(text = option.text)
            }
        }
    }
}


@Composable
fun EcoNoviceDialog(onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = { Text("Congratulations!") },
        text = {
            Column {
                Image(painter = painterResource(id = R.drawable.eco_novice_220x220_transp), contentDescription = "Eco Novice")
                Text("You have become an Eco Novice. Keep going to reach the next level!")
            }
        },
        confirmButton = {
            Button(onClick = onDismiss) {
                Text("Continue")
            }
        }
    )
}

@Composable
fun EcoApprenticeDialog(onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = {  },
        title = { Text("Congratulations!") },
        text = {
            Column {
                Image(painter = painterResource(id = R.drawable.eco_apprentice_220x220_transp), contentDescription = "Eco Apprentice")
                Text("You have become an Eco Apprentice. Keep up the good work!")
            }
        },
        confirmButton = {
            Button(onClick = onDismiss) {
                Text("Continue")
            }
        }
    )
}

@Composable
fun EcoMasterDialog(onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = {  },
        title = { Text("Congratulations!") },
        text = {
            Column {
                Image(painter = painterResource(id = R.drawable.eco_master_220x220_transp), contentDescription = "Eco Master")
                Text("You are now an Eco Master! Excellent job!")
            }
        },
        confirmButton = {
            Button(onClick = onDismiss) {
                Text("Continue")
            }
        }
    )
}

@Composable
@Preview
fun GameScreenPreview() {
    UnscrambleTheme {
        val navController = rememberNavController()
        val gameViewModel = viewModel<QuizViewModel>()

        GameScreen(navController, gameViewModel)
    }
}