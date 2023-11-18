package com.example.TechTusQuiz.ui


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.TechTusQuiz.data.Question
import com.example.TechTusQuiz.data.QuestionsRepository
import com.example.unscramble.R
import com.example.unscramble.frame42.inter
import com.google.relay.compose.CrossAxisAlignment
import com.google.relay.compose.MainAxisAlignment
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayContainerArrangement
import com.google.relay.compose.RelayContainerScope
import com.google.relay.compose.RelayImage
import com.google.relay.compose.RelayText
import com.google.relay.compose.RelayVector
import com.google.relay.compose.RowScopeInstanceImpl.align
import com.google.relay.compose.RowScopeInstanceImpl.weight


/**
 * trying again new layout
 *
 * This composable was generated from the UI Package 'frame_42'.
 * Generated code; do not edit directly
 */


@Composable
fun GameScreen4(navController: NavHostController, gameViewModel: QuizViewModel = viewModel()) {
    val currentQuestion by gameViewModel.currentQuestion.observeAsState()
    val currentScore by gameViewModel.currentScore.observeAsState(0)
    val isGameOver by gameViewModel.isGameOver.observeAsState(false)
    val explanation by gameViewModel.selectedAnswerExplanation.observeAsState()
    val currentQuestionIndex by gameViewModel.currentQuestionIndex.observeAsState(0)
    val isCorrect by gameViewModel.isLastAnswerCorrect.observeAsState()

    var showDialog by remember { mutableStateOf(false) }

    currentQuestion?.let { question ->
        Frame42(
            question,
            gameViewModel,
            currentQuestionIndex,
            currentScore,
            modifier = Modifier
        )

        Box(modifier = Modifier.fillMaxSize())

        LaunchedEffect(explanation) {
            if (!explanation.isNullOrEmpty()) {
                showDialog = true
            }
        }

        if (showDialog) {
            ExplanationDialog(
                explanation = explanation ?: "",
                isCorrect = isCorrect,
                onDismiss = {
                    showDialog = false
                    gameViewModel.resetExplanation()
                    if (gameViewModel.isGameOver.value != true) {
                        gameViewModel.proceedToNextQuestion()
                    }
                }
            )
        }
    }

    if (isGameOver) {
        LaunchedEffect(Unit) {
            navController.navigate("gameOverScreen")
        }
    }
}
@Composable
fun Frame42(question: Question, gameViewModel: QuizViewModel, questionIndex: Int, currentScore: Int, modifier: Modifier = Modifier) {
    TopLevel5(modifier = modifier) {
        Frame52(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 56.0.dp,
                    y = 20.0.dp
                )
            )
        ) {
            GameLogo5(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
        }
        Frame51(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 195.0.dp,
                    y = 39.0.dp
                )
            )
        ) {
            QustionNum(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
        }
        Frame50(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 383.0.dp,
                    y = 39.0.dp
                )
            )
        ) {
            Score(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
        }
        Frame43(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 56.0.dp,
                    y = 139.0.dp
                )
            )
        ) {
            QuestionBox1(question, modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
        }
        Frame44(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 56.0.dp,
                    y = 348.0.dp
                )
            )
        ) {
            Answer1(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
        }
        Frame45(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 56.0.dp,
                    y = 467.0.dp
                )
            )
        ) {
            Answer2(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
        }
        Frame46(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 57.0.dp,
                    y = 586.0.dp
                )
            )
        ) {
            Answer3(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
        }
        Frame47(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 56.0.dp,
                    y = 705.0.dp
                )
            )
        ) {
            Answer4(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
        }
        Frame48(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 57.0.dp,
                    y = 824.0.dp
                )
            )
        ) {
            RestartButton(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
        }
        Frame49(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 283.0.dp,
                    y = 824.0.dp
                )
            )
        ) {
            ExitButton(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
        }
    }
}

@Preview (widthDp = 555, heightDp = 933)
@Composable
private fun Frame42Preview(gameViewModel: QuizViewModel= viewModel()) {
    val questionsRepository = QuestionsRepository()
    val questionsList = questionsRepository.getQuestions()

    // Create a mock question and score
    val mockQuestion = questionsList.first()
    val mockScore = 0 // Mock score

    // Create a mock view model
    val mockViewModel = gameViewModel
    MaterialTheme {
        RelayContainer {
            Frame42( question = mockQuestion,
                gameViewModel = mockViewModel, // Pass the mock view model
                questionIndex = 0,
                currentScore = mockScore,modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
        }
    }
}

@Composable
fun GameLogo5(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.frame_42_game_logo_1),
        contentScale = ContentScale.Crop,
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Frame52(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        arrangement = RelayContainerArrangement.Row,
        padding = PaddingValues(all = 10.0.dp),
        itemSpacing = 10.0,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(120.0.dp).requiredHeight(120.0.dp)
    )
}

@Composable
fun QustionNum(modifier: Modifier = Modifier) {
    RelayText(
        content = "Q 6",
        fontSize = 32.0.sp,
        fontFamily = inter,
        color = Color(
            alpha = 255,
            red = 255,
            green = 255,
            blue = 255
        ),
        height = 1.2102272510528564.em,
        textAlign = TextAlign.Left,
        maxLines = -1,
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Frame51(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        arrangement = RelayContainerArrangement.Row,
        padding = PaddingValues(all = 10.0.dp),
        itemSpacing = 10.0,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(74.0.dp)
    )
}

@Composable
fun Score(modifier: Modifier = Modifier) {
    RelayText(
        content = "Score: 0",
        fontSize = 32.0.sp,
        fontFamily = inter,
        color = Color(
            alpha = 255,
            red = 255,
            green = 255,
            blue = 255
        ),
        height = 1.2102272510528564.em,
        textAlign = TextAlign.Left,
        maxLines = -1,
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Frame50(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        arrangement = RelayContainerArrangement.Row,
        padding = PaddingValues(all = 10.0.dp),
        itemSpacing = 10.0,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(146.0.dp)
    )
}

@Composable
fun QuestionBox1(question: Question, modifier: Modifier = Modifier) {


    RelayVector(
        vector = painterResource(R.drawable.frame_42_question_box),
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
    Text(
        text = question.text,
        fontSize = 16.sp,
        color = Color.Black,
        modifier = Modifier
            .align(Alignment.Bottom)
            .weight(1.5f), // Adjust weight to allocate more space to text
        maxLines = 5, // Limit the number of lines to prevent text from becoming too small
        overflow = TextOverflow.Ellipsis // Add ellipsis if text exceeds max lines
    )
    Image(
        painter = painterResource(id = question.questionImage),
        contentDescription = "Question Image",
        modifier = Modifier
            .align(Alignment.Bottom)
            .size(180.dp) // Slightly reduce image size
            .weight(1f) // Adjust weight for image
    )
}

@Composable
fun Frame43(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        padding = PaddingValues(all = 10.0.dp),
        itemSpacing = 10.0,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(442.0.dp).requiredHeight(194.0.dp)
    )
}

@Composable
fun Answer1(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.frame_42_answer1),
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Frame44(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        padding = PaddingValues(all = 10.0.dp),
        itemSpacing = 10.0,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(442.0.dp).requiredHeight(104.0.dp)
    )
}

@Composable
fun Answer2(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.frame_42_answer2),
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Frame45(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        padding = PaddingValues(all = 10.0.dp),
        itemSpacing = 10.0,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(442.0.dp).requiredHeight(104.0.dp)
    )
}

@Composable
fun Answer3(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.frame_42_answer3),
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Frame46(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        padding = PaddingValues(all = 10.0.dp),
        itemSpacing = 10.0,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(442.0.dp).requiredHeight(104.0.dp)
    )
}

@Composable
fun Answer4(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.frame_42_answer4),
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Frame47(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        padding = PaddingValues(all = 10.0.dp),
        itemSpacing = 10.0,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(442.0.dp).requiredHeight(104.0.dp)
    )
}

@Composable
fun RestartButton(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.frame_42_restart_button),
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Frame48(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        padding = PaddingValues(all = 10.0.dp),
        itemSpacing = 10.0,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(220.0.dp).requiredHeight(85.0.dp)
    )
}

@Composable
fun ExitButton(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.frame_42_exit_button),
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Frame49(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        padding = PaddingValues(all = 10.0.dp),
        itemSpacing = 10.0,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(220.0.dp).requiredHeight(85.0.dp)
    )
}

@Composable
fun TopLevel5(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        backgroundColor = Color(
            alpha = 255,
            red = 0,
            green = 89,
            blue = 76
        ),
        isStructured = false,
        content = content,
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}