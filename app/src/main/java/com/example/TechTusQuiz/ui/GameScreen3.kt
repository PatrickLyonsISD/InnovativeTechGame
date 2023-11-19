package com.example.TechTusQuiz.ui



import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
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
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.TechTusQuiz.data.Option
import com.example.TechTusQuiz.data.Question
import com.example.TechTusQuiz.data.QuestionsRepository
import com.example.unscramble.R
import com.google.relay.compose.BoxScopeInstanceImpl.align
import com.google.relay.compose.CrossAxisAlignment
import com.google.relay.compose.MainAxisAlignment
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayContainerArrangement
import com.google.relay.compose.RelayContainerScope
import com.google.relay.compose.RelayImage
import com.google.relay.compose.RelayVector

@Composable
fun GameScreen3(navController: NavHostController, gameViewModel: QuizViewModel = viewModel()) {
    val currentQuestion by gameViewModel.currentQuestion.observeAsState()
    val currentScore by gameViewModel.currentScore.observeAsState(0)
    val isGameOver by gameViewModel.isGameOver.observeAsState(false)
    val explanation by gameViewModel.selectedAnswerExplanation.observeAsState()
    val currentQuestionIndex by gameViewModel.currentQuestionIndex.observeAsState(0)
    val isCorrect by gameViewModel.isLastAnswerCorrect.observeAsState()

    var showDialog by remember { mutableStateOf(false) }

    currentQuestion?.let { question ->
        AndroidSmall1(
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

    if (gameViewModel.isGameOver.value == true) {
        LaunchedEffect(Unit) {
            val score = gameViewModel.currentScore.value ?: 0
            navController.navigate("gameOverScreen/$score")
        }
    }
}


    /**
     * using auto layout to fix spilling issue
     *
     * This composable was generated from the UI Package 'android_small_1'.
     * Generated code; do not edit directly
     */

    @Composable
    fun GameOverScreen(gameViewModel: QuizViewModel) {
        // Assuming you have a currentScore LiveData in your ViewModel
        val score by gameViewModel.currentScore.observeAsState(0)

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Game Over!", fontSize = 24.sp)
                Text("Your score: $score", fontSize = 20.sp)
                Button(onClick = { gameViewModel.resetGame() }) {
                    Text("Play Again")
                }
                // Add more buttons or actions as needed
            }
        }
    }
    @Composable
    fun AndroidSmall1(question: Question, gameViewModel: QuizViewModel, questionIndex: Int, currentScore: Int, modifier: Modifier = Modifier) {
        TopLevel3(modifier = modifier) {
            Frame9(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = -10.0.dp,
                        y = 7.0.dp
                    )
                )
            ) {
                GameLogo3(modifier = Modifier
                    .rowWeight(1.0f)
                    .columnWeight(1.0f))
            }
            Frame8(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 70.0.dp,
                        y = 6.0.dp
                    )
                )
            ) {
                QuestionNum(questionNumber = questionIndex + 1)
            }
            Frame10(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 166.0.dp,
                        y = 7.0.dp
                    )
                )
            ) {
                Score(score = currentScore, modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
            }
            Frame7(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 25.0.dp,
                        y = 101.0.dp
                    )
                )
            ) {
                QuestionBox(question, modifier = Modifier
                    .rowWeight(1.0f)
                    .columnWeight(1.0f))
            }
            Frame12(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 180.0.dp,
                        y = 268.0.dp
                    )
                )
            ) {
                Answer2(
                    option = question.options[1],
                    gameViewModel = gameViewModel,
                    modifier = Modifier.size(150.dp)
                )
            }
            Frame11(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 25.0.dp,
                        y = 268.0.dp
                    )
                )
            ) {
                Answer1(
                    option = question.options.firstOrNull(),
                    gameViewModel = gameViewModel,
                    modifier = Modifier.size(150.dp)
                )
            }
            Frame14(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 180.0.dp,
                        y = 412.0.dp
                    )
                )
            ) {
                Answer4(option = question.options[3],
                    gameViewModel = gameViewModel,
                    modifier = Modifier.size(150.dp)
                )
            }
            Frame13(
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(
                        x = 25.0.dp,
                        y = 412.0.dp
                    )
                )
            ) {
                Answer3( option = question.options[2],
                    gameViewModel = gameViewModel,
                    modifier = Modifier.size(150.dp)
                )
            }
            Frame16(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .absolutePadding(right=20.dp)
            ) {
                Exit(modifier = Modifier.size(150.dp))
            }
            Frame15(
                modifier = Modifier
                    .align(Alignment.BottomStart) // Align to bottom left
            ) {
                Restart3(modifier = Modifier.size(150.dp)) // Adjust size as needed
            }
        }
    }



    @Composable
    fun GameLogo3(modifier: Modifier = Modifier) {
        RelayImage(
            image = painterResource(R.drawable.android_small_1_game_logo_1),
            //check if content scale.fit works if needs to change
            contentScale = ContentScale.Fit,
            modifier = modifier
                .fillMaxWidth(1.0f)
                .fillMaxHeight(1.0f)
                .absolutePadding(bottom=8.dp)
        )
    }

    @Composable
    fun Frame9(
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
            modifier = modifier
                .requiredWidth(110.0.dp)
                .requiredHeight(110.0.dp)
        )
    }

    @Composable
    fun QuestionNum(questionNumber: Int, modifier: Modifier = Modifier) {
        Box(modifier = modifier) {
            RelayVector(

                modifier = Modifier
                    .matchParentSize() // Make the vector fill the entire Box
            )

            Text(
                text = "Q ${questionNumber}",
                fontSize = 28.sp,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.Center)
                    .absolutePadding(left=20.dp, top=8.dp)
            )
        }
    }

    @Composable
    fun Frame8(
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
            modifier = modifier
                .absolutePadding(left=20.dp)
        )
    }

    @Composable
    fun Score(score: Int, modifier: Modifier = Modifier) {
        Box(modifier = modifier) {
            RelayVector(

                modifier = Modifier.matchParentSize() // Make the vector fill the entire Box
            )

            Text(
                text = "Score: $score", // Display the score
                fontSize = 28.sp,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.Center) // Center the text inside the Box
                    .absolutePadding(top=5.dp)
            )
        }
    }

    @Composable
    fun Frame10(
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
            modifier = modifier
                .requiredWidth(170.0.dp)
                .requiredHeight(85.0.dp)
                .absolutePadding(left=20.dp)
        )
    }

    @Composable
    fun QuestionBox(question: Question, modifier: Modifier = Modifier) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            RelayVector(
                vector = painterResource(R.drawable.android_small_1_question_box),
                modifier = Modifier
                    .matchParentSize()
                    .fillMaxWidth()
            )

            Row(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(horizontal = 8.dp)
            ) {
                // Text block
                Text(
                    text = question.text,
                    fontSize = 16.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .weight(1.5f), // Adjust weight to allocate more space to text
                    maxLines = 5, // Limit the number of lines to prevent text from becoming too small
                    overflow = TextOverflow.Ellipsis // Add ellipsis if text exceeds max lines
                )

                // Spacer for separating text and image


                // Image block
                Image(
                    painter = painterResource(id = question.questionImage),
                    contentDescription = "Question Image",
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .size(80.dp) // Slightly reduce image size
                        .weight(0.7f) // Adjust weight for image
                )
            }
        }
    }

@Composable
fun ExplanationDialog(explanation: String, isCorrect: Boolean?, onDismiss: () -> Unit) {
    val icon = when (isCorrect) {
        true -> Icons.Default.Check // Tick icon for correct answer
        false -> Icons.Default.Close // Cross icon for incorrect answer
        else -> null // No icon if null
    }

    AlertDialog(
        onDismissRequest = { /* Do nothing, require explicit dismissal */ },
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                icon?.let { Icon(it, contentDescription = null) }
                Spacer(Modifier.width(8.dp))
                Text("Explanation")
            }
        },
        text = { Text(explanation) },
        confirmButton = {
            Button(onClick = onDismiss) {
                Text("OK")
            }
        }
    )
}

@Composable
    fun Frame7(
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
            modifier = modifier
                .padding(end = 50.dp)
                .requiredWidth(370.0.dp)
                .requiredHeight(180.0.dp)

        )
    }

    @Composable
    fun Answer2(option: Option?, gameViewModel: QuizViewModel, modifier: Modifier = Modifier)
    {
        Box(
            modifier = modifier
                .clickable { gameViewModel.submitAnswer(1) }
        ) {
            // Background Image
            RelayImage(
                image = painterResource(R.drawable.android_small_1_answer_2),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clickable { gameViewModel.submitAnswer(1)}
                    .requiredWidth(200.dp)
                    .requiredHeight(200.dp)
                    .padding(20.dp)// This ensures the background image fills the box
            )

            // Layout for the option content
            option?.let { opt ->
                Column(
                    modifier = Modifier
                        .align(Alignment.Center) // Center the content in the Box
                        .padding(16.dp) // Add some padding around the content
                ) {
                    Image(
                        painter = painterResource(id = opt.image),
                        contentDescription = opt.text,
                        modifier = Modifier
                            .size(60.dp) // Standardize the size of the image
                            .align(Alignment.CenterHorizontally) // Center the image horizontally in the Column
                    )

                    Text(
                        text = opt.text,
                        fontSize = 16.sp, // Standardize the text size
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally) // Center the text horizontally in the Column
                    )
                }
            }
        }
    }

    @Composable
    fun Frame12(
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
            modifier = modifier
                .absolutePadding(left = 20.dp,
                    bottom=20.dp,
                    top=50.dp)
        )
    }

    @Composable
    fun Answer1(option: Option?, gameViewModel: QuizViewModel, modifier: Modifier = Modifier)
    {
        Box(
            modifier = modifier
                .clickable { gameViewModel.submitAnswer(0) }
        ) {
            // Background Image
            RelayImage(
                image = painterResource(R.drawable.android_small_1_answer_2),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clickable { gameViewModel.submitAnswer(0)}
                    .requiredWidth(200.dp)
                    .requiredHeight(200.dp)
                    .padding(20.dp)// This ensures the background image fills the box
            )

            // Layout for the option content
            option?.let { opt ->
                Column(
                    modifier = Modifier
                        .align(Alignment.Center) // Center the content in the Box
                        .padding(16.dp) // Add some padding around the content
                ) {
                    Image(
                        painter = painterResource(id = opt.image),
                        contentDescription = opt.text,
                        modifier = Modifier
                            .size(60.dp) // Standardize the size of the image
                            .align(Alignment.CenterHorizontally) // Center the image horizontally in the Column
                    )

                    Text(
                        text = opt.text,
                        fontSize = 16.sp, // Standardize the text size
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally) // Center the text horizontally in the Column
                    )
                }
            }
        }
    }

    @Composable
    fun Frame11(
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
            modifier = modifier
                .absolutePadding(right = 20.dp,
                    bottom=20.dp,
                    top=50.dp)

        )
    }

    @Composable
    fun Answer4(option: Option?, gameViewModel: QuizViewModel, modifier: Modifier = Modifier)
    {
        Box(
            modifier = modifier
                .clickable { gameViewModel.submitAnswer(3) }
        ) {
            // Background Image
            RelayImage(
                image = painterResource(R.drawable.android_small_1_answer_2),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clickable { gameViewModel.submitAnswer(3)}
                    .requiredWidth(200.dp)
                    .requiredHeight(200.dp)
                    .padding(20.dp)// This ensures the background image fills the box
            )

            // Layout for the option content
            option?.let { opt ->
                Column(
                    modifier = Modifier
                        .align(Alignment.Center) // Center the content in the Box
                        .padding(16.dp) // Add some padding around the content
                ) {
                    Image(
                        painter = painterResource(id = opt.image),
                        contentDescription = opt.text,
                        modifier = Modifier
                            .size(60.dp) // Standardize the size of the image
                            .align(Alignment.CenterHorizontally) // Center the image horizontally in the Column
                    )

                    Text(
                        text = opt.text,
                        fontSize = 16.sp, // Standardize the text size
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally) // Center the text horizontally in the Column
                    )
                }
            }
        }
    }

    @Composable
    fun Frame14(
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
            modifier = modifier

                .absolutePadding(left = 20.dp, top=80.dp)
        )
    }

    @Composable
    fun Answer3(option: Option?, gameViewModel: QuizViewModel, modifier: Modifier = Modifier)
    {
        Box(
            modifier = modifier
                .clickable { gameViewModel.submitAnswer(2) }
        ) {
            // Background Image
            RelayImage(
                image = painterResource(R.drawable.android_small_1_answer_2),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clickable { gameViewModel.submitAnswer(2)}
                    .requiredWidth(200.dp)
                    .requiredHeight(200.dp)
                    .padding(20.dp)
            )

            // Layout for the option content
            option?.let { opt ->
                Column(
                    modifier = Modifier
                        .align(Alignment.Center) // Center the content in the Box
                        .padding(16.dp) // Add some padding around the content
                ) {
                    Image(
                        painter = painterResource(id = opt.image),
                        contentDescription = opt.text,
                        modifier = Modifier
                            .size(60.dp) // Standardize the size of the image
                            .align(Alignment.CenterHorizontally) // Center the image horizontally in the Column
                    )

                    Text(
                        text = opt.text,
                        fontSize = 16.sp, // Standardize the text size
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally) // Center the text horizontally in the Column
                    )
                }
            }
        }
    }

    @Composable
    fun Frame13(
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
            modifier = modifier
                .absolutePadding(right=20.dp,
                    top=80.dp)
        )
    }

    @Composable
    fun Exit(modifier: Modifier = Modifier) {
        Box(modifier = modifier) {
            RelayVector(
                modifier = Modifier
                    .matchParentSize() // Fill the box
            )

            Text(
                text = "Exit",
                fontSize = 36.sp, // Adjust font size as needed
                color = Color.White, // Choose appropriate text color
                modifier = Modifier
                    .align(Alignment.Center) // Center the text in the Box
            )
        }
    }
    @Composable
    fun Frame16(
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
            modifier = modifier
                .requiredWidth(160.0.dp)
                .requiredHeight(82.0.dp)
                .absolutePadding()
        )
    }

    @Composable
    fun Restart3(modifier: Modifier = Modifier) {
        Box(modifier = modifier) {
            RelayVector(

                modifier = Modifier
                    .matchParentSize() // Fill the box
            )

            Text(
                text = "Restart",
                fontSize = 36.sp, // Adjust font size as needed
                color = Color.White, // Choose appropriate text color
                modifier = Modifier
                    .align(Alignment.CenterEnd) // Center the text in the Box
            )
        }
    }

    @Composable
    fun Frame15(
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
            modifier = modifier
                .requiredWidth(200.0.dp)
                .requiredHeight(82.0.dp)
        )
    }

    @Composable
    fun TopLevel3(
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
            modifier = modifier
                .fillMaxWidth(1.0f)
                .fillMaxHeight(1.0f)
        )
    }


@Preview
@Composable
private fun AndroidSmall1Preview(gameViewModel: QuizViewModel= viewModel()) {
    val questionsRepository = QuestionsRepository()
    val questionsList = questionsRepository.getQuestions()

    // Create a mock question and score
    val mockQuestion = questionsList.first()
    val mockScore = 0 // Mock score

    // Create a mock view model
    val mockViewModel = gameViewModel

    MaterialTheme {
        RelayContainer {
            AndroidSmall1(
                question = mockQuestion,
                gameViewModel = mockViewModel, // Pass the mock view model
                questionIndex = 0,
                currentScore = mockScore,
                modifier = Modifier
                    .rowWeight(1.0f)
                    .columnWeight(1.0f)
            )
        }
    }
}