package com.example.TechTusQuiz.ui



import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
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
fun GameScreen3(gameViewModel: QuizViewModel= viewModel()) {
    val currentQuestion by gameViewModel.currentQuestion.observeAsState()
    val currentScore by gameViewModel.currentScore.observeAsState(0)
    val isGameOver by gameViewModel.isGameOver.observeAsState(false)
    val selectedAnswerExplanation by gameViewModel.selectedAnswerExplanation.observeAsState()
    val currentQuestionIndex by gameViewModel.currentQuestionIndex.observeAsState(0)

    currentQuestion?.let { question ->
        AndroidSmall1(question, currentQuestionIndex, currentScore, modifier = Modifier)


    }
}


/**
 * using auto layout to fix spilling issue
 *
 * This composable was generated from the UI Package 'android_small_1'.
 * Generated code; do not edit directly
 */
@Composable
fun AndroidSmall1(question: Question, questionIndex: Int, currentScore: Int, modifier: Modifier = Modifier) {
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
                modifier = Modifier.size(150.dp)
            )
        }
        Frame16(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 180.0.dp,
                    y = 556.0.dp
                )
            )
        ) {
            Exit()
        }
        Frame15(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 6.0.dp,
                    y = 556.0.dp
                )
            )
        ) {
            Restart3(modifier = Modifier
                .rowWeight(1.0f)
                .columnWeight(1.0f))
        }
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
private fun AndroidSmall1Preview() {
    val questionsRepository = QuestionsRepository()
    val questionsList = questionsRepository.getQuestions()

    // Take the first question or any specific one you want to display in the preview
    val mockQuestion = questionsList.first()
    val mockScore = 0 // Mock score

    MaterialTheme {
        RelayContainer {
            AndroidSmall1(
                question = mockQuestion,
                questionIndex = 0, // Mock question index
                currentScore = mockScore, // Mock score
                modifier = Modifier
                    .rowWeight(1.0f)
                    .columnWeight(1.0f)
            )
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
            .requiredWidth(90.0.dp)
            .requiredHeight(85.0.dp)
    )
}

@Composable
fun QuestionNum(questionNumber: Int, modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        RelayVector(
            vector = painterResource(R.drawable.android_small_1_question_num),
            modifier = Modifier
                .matchParentSize() // Make the vector fill the entire Box
        )

        Text(
            text = "Q${questionNumber + 1}",
            fontSize = 45.sp,
            color = Color.Black,
            modifier = Modifier
                .align(Alignment.Center) // Center the text inside the Box
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
    )
}

@Composable
fun Score(score: Int, modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        RelayVector(
            vector = painterResource(R.drawable.android_small_1_score),
            modifier = Modifier.matchParentSize() // Make the vector fill the entire Box
        )

        Text(
            text = "Score: $score", // Display the score
            fontSize = 35.sp,
            color = Color.Black,
            modifier = Modifier.align(Alignment.Center) // Center the text inside the Box
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
    )
}

@Composable
fun QuestionBox(question: Question, modifier: Modifier = Modifier) {
    Box(modifier = modifier
        .fillMaxWidth()
    ) {
        RelayVector(
            vector = painterResource(R.drawable.android_small_1_question_box),
            modifier = Modifier.matchParentSize()
        )

        Row(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = 8.dp) // Add some padding around the Row
        ) {
            // Text block
            Text(
                text = question.text,
                fontSize = 16.sp,
                color = Color.Black,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(1f) // Text takes as much space as it can
            )

            // Spacer for separating text and image
            Spacer(modifier = Modifier.width(8.dp))

            // Image block
            Image(
                painter = painterResource(id = question.questionImage),
                contentDescription = "Question Image",
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .size(100.dp) // Adjust the size as needed
            )
        }
    }
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
            .requiredWidth(297.0.dp)
            .requiredHeight(157.0.dp)
    )
}

@Composable
fun Answer2(option: Option?, modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        // Background Image
        RelayImage(
            image = painterResource(R.drawable.android_small_1_answer_2),
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize() // This ensures the background image fills the box
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
            .requiredWidth(141.0.dp)
            .requiredHeight(142.0.dp)
    )
}

@Composable
fun Answer1(option: Option?, modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        // Background Image
        RelayImage(
            image = painterResource(R.drawable.android_small_1_answer_2),
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize() // This ensures the background image fills the box
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
            .requiredWidth(141.0.dp)
            .requiredHeight(142.0.dp)
    )
}

@Composable
fun Answer4(option: Option?, modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        // Background Image
        RelayImage(
            image = painterResource(R.drawable.android_small_1_answer_2),
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize() // This ensures the background image fills the box
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
            .requiredWidth(141.0.dp)
            .requiredHeight(142.0.dp)
    )
}

@Composable
fun Answer3(option: Option?, modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        // Background Image
        RelayImage(
            image = painterResource(R.drawable.android_small_1_answer_2),
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize() // This ensures the background image fills the box
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
            .requiredWidth(141.0.dp)
            .requiredHeight(142.0.dp)
    )
}

@Composable
fun Exit(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        RelayVector(
            vector = painterResource(R.drawable.android_small_1_exit),
            modifier = Modifier
                .matchParentSize() // Fill the box
        )

        Text(
            text = "Exit",
            fontSize = 45.sp, // Adjust font size as needed
            color = Color.Black, // Choose appropriate text color
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
    )
}

@Composable
fun Restart3(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        RelayVector(
            vector = painterResource(R.drawable.android_small_1_restart),
            modifier = Modifier
                .matchParentSize() // Fill the box
        )

        Text(
            text = "Restart",
            fontSize = 41.sp, // Adjust font size as needed
            color = Color.Black, // Choose appropriate text color
            modifier = Modifier
                .align(Alignment.Center) // Center the text in the Box
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
            .requiredWidth(160.0.dp)
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