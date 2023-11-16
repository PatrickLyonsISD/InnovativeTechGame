package com.example.TechTusQuiz.ui

import com.example.unscramble.q2question.inter


import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.TechTusQuiz.data.Question
import com.example.TechTusQuiz.ui.theme.UnscrambleTheme
import com.example.unscramble.R
import com.example.unscramble.q2question.ButtonPlay1
import com.example.unscramble.q2question.ButtonPlay2
import com.example.unscramble.q2question.ButtonPlay3
import com.example.unscramble.q2question.Consumer1
import com.example.unscramble.q2question.Disposal
import com.example.unscramble.q2question.Disposal1
import com.example.unscramble.q2question.Factory1
import com.example.unscramble.q2question.GameLogo1
import com.example.unscramble.q2question.Jeans1
import com.example.unscramble.q2question.Pink210x2101
import com.example.unscramble.q2question.Pink210x2102
import com.example.unscramble.q2question.Pink210x2103
import com.example.unscramble.q2question.Pink210x2104
import com.example.unscramble.q2question.Q2
import com.example.unscramble.q2question.Q2Question
import com.example.unscramble.q2question.Rectangle1
import com.example.unscramble.q2question.Transport
import com.example.unscramble.q2question.Transport1
import com.example.unscramble.q2question.WhichPhaseOfATextilesLifecycleReleasesTheMostGreenhouseGasses
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayContainerScope
import com.google.relay.compose.RelayImage
import com.google.relay.compose.RelayText
import com.google.relay.compose.RelayVector

/**
 * New Screen layout (ver 2)
 *
 * This composable was generated from the UI Package 'q2_question'.
 * Generated code; do not edit directly
 */

@Composable
fun GameScreen2(gameViewModel: QuizViewModel = viewModel()) {
    val currentQuestion by gameViewModel.currentQuestion.observeAsState()
    val currentScore by gameViewModel.currentScore.observeAsState(0)
    val currentQuestionIndex by gameViewModel.currentQuestionIndex.observeAsState(0)
    val isGameOver by gameViewModel.isGameOver.observeAsState(false)
    val selectedAnswerExplanation by gameViewModel.selectedAnswerExplanation.observeAsState()

    Q2Question(
        currentQuestion = currentQuestion,
        currentScore = currentScore,
        currentQuestionIndex = currentQuestionIndex,
        modifier = Modifier // Your Modifier here
    )
}
@Composable
fun Q2Question(
    currentQuestion: Question?,
    currentScore: Int,
    currentQuestionIndex: Int,
    modifier: Modifier = Modifier
) {
    TopLevel(modifier = modifier) {
        Pink210x2101(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 26.0.dp,
                    y = 276.0.dp
                )
            )
        )
        Pink210x2103(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 26.0.dp,
                    y = 495.0.dp
                )
            )
        )
        Pink210x2102(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 245.0.dp,
                    y = 276.0.dp
                )
            )
        )
        Rectangle1(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 31.0.dp,
                    y = 124.0.dp
                )
            )
        )


        currentQuestion?.let { question ->
            WhichPhaseOfATextilesLifecycleReleasesTheMostGreenhouseGasses(
                questionText = question.text,
                modifier = Modifier.boxAlign(
                    alignment = Alignment.TopStart,
                    offset = DpOffset(x = 61.0.dp, y = 159.0.dp)
                )
            )
        }
        

        currentAnswer?.let { answer ->
        Factory(
            AnswerText= answer.text,
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 90.0.dp,
                    y = 441.0.dp
                )
            )
        }
        Disposal(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 306.0.dp,
                    y = 441.0.dp
                )
            )
        )
        Transport(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 90.0.dp,
                    y = 655.0.dp
                )
            )
        )
        ButtonPlay(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 240.0.dp,
                    y = 23.0.dp
                )
            )
        )
        ButtonPlay1(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 139.0.dp,
                    y = 23.0.dp
                )
            )
        )


        Score0(
            score = currentScore,
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(x = 282.0.dp, y = 36.0.dp)
            )
        )

        Q2(
            questionNumber = currentQuestionIndex,
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(x = 158.0.dp, y = 36.0.dp)
            )
        )

        GameLogo1(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 31.0.dp,
                    y = 15.0.dp
                )
            )
        )
        ButtonPlay2(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 248.0.dp,
                    y = 717.0.dp
                )
            )
        )
        ButtonPlay3(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 30.0.dp,
                    y = 717.0.dp
                )
            )
        )
        Exit(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 320.0.dp,
                    y = 730.0.dp
                )
            )
        )
        Restart(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 75.0.dp,
                    y = 730.0.dp
                )
            )
        )
        Pink210x2104(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 248.0.dp,
                    y = 497.0.dp
                )
            )
        )
        Jeans1(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 321.0.dp,
                    y = 150.0.dp
                )
            )
        )
        Factory1(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 61.0.dp,
                    y = 297.0.dp
                )
            )
        )
        Disposal1(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 280.0.dp,
                    y = 285.0.dp
                )
            )
        )
        Transport1(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 58.0.dp,
                    y = 509.0.dp
                )
            )
        )
        Consumer1(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 285.0.dp,
                    y = 529.0.dp
                )
            )
        )
        Consumer(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 302.0.dp,
                    y = 655.0.dp
                )
            )
        )
    }
}

//@Preview(widthDp = 480, heightDp = 800)

@Composable
private fun Q2QuestionPreview() {
    MaterialTheme {
        RelayContainer {
            Q2Question(modifier = Modifier
                .rowWeight(1.0f)
                .columnWeight(1.0f))
        }
    }
}

@Composable
fun Pink210x2101(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.q2_question_pink_210x210_1),
        contentScale = ContentScale.Crop,
        modifier = modifier
            .requiredWidth(210.0.dp)
            .requiredHeight(210.0.dp)
    )
}

@Composable
fun Pink210x2103(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.q2_question_pink_210x210_1),
        contentScale = ContentScale.Crop,
        modifier = modifier
            .requiredWidth(210.0.dp)
            .requiredHeight(210.0.dp)
    )
}

@Composable
fun Pink210x2102(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.q2_question_pink_210x210_1),
        contentScale = ContentScale.Crop,
        modifier = modifier
            .requiredWidth(210.0.dp)
            .requiredHeight(210.0.dp)
    )
}

@Composable
fun Rectangle1(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.q2_question_rectangle_1),
        modifier = modifier
            .requiredWidth(417.0.dp)
            .requiredHeight(137.0.dp)
    )
}
@Composable
fun WhichPhaseOfATextilesLifecycleReleasesTheMostGreenhouseGasses(
    questionText: String,
    modifier: Modifier = Modifier
) {
    RelayText(
        content = questionText,
        fontSize = 20.0.sp,
        fontFamily = inter,
        color = Color(alpha = 255, red = 0, green = 0, blue = 0),
        height = 1.2102272033691406.em,
        textAlign = TextAlign.Left,
        maxLines = -1,
        modifier = modifier.requiredWidth(299.0.dp).requiredHeight(83.0.dp)
    )
}

@Composable
fun Factory(AnswerText: String, modifier: Modifier = Modifier) {
    RelayText(
        content = AnswerText,
        fontSize = 20.0.sp,
        fontFamily = inter,
        color = Color(
            alpha = 255,
            red = 0,
            green = 0,
            blue = 0
        ),
        height = 1.2102272033691406.em,
        textAlign = TextAlign.Left,
        maxLines = -1,
        modifier = modifier
            .requiredWidth(80.0.dp)
            .requiredHeight(27.0.dp)
    )
}

@Composable
fun Disposal(modifier: Modifier = Modifier) {
    RelayText(
        content = "Disposal",
        fontSize = 20.0.sp,
        fontFamily = inter,
        color = Color(
            alpha = 255,
            red = 0,
            green = 0,
            blue = 0
        ),
        height = 1.2102272033691406.em,
        textAlign = TextAlign.Left,
        maxLines = -1,
        modifier = modifier
            .requiredWidth(88.0.dp)
            .requiredHeight(27.0.dp)
    )
}

@Composable
fun Transport(modifier: Modifier = Modifier) {
    RelayText(
        content = "Transport",
        fontSize = 20.0.sp,
        fontFamily = inter,
        color = Color(
            alpha = 255,
            red = 0,
            green = 0,
            blue = 0
        ),
        height = 1.2102272033691406.em,
        textAlign = TextAlign.Left,
        maxLines = -1,
        modifier = modifier
            .requiredWidth(95.0.dp)
            .requiredHeight(27.0.dp)
    )
}

@Composable
fun ButtonPlay(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.q2_question_button_play),
        modifier = modifier
            .requiredWidth(210.0.dp)
            .requiredHeight(65.0.dp)
    )
}

@Composable
fun ButtonPlay1(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.q2_question_button_play1),
        modifier = modifier
            .requiredWidth(86.0.dp)
            .requiredHeight(65.0.dp)
    )
}

@Composable
fun Score0(score: Int, modifier: Modifier = Modifier) {
    RelayText(
        content = "Score: $score",
        fontSize = 32.0.sp,
        fontFamily = inter,
        color = Color(
            alpha = 255,
            red = 0,
            green = 0,
            blue = 0
        ),
        height = 1.2102272510528564.em,
        textAlign = TextAlign.Left,
        modifier = modifier
    )
}


@Composable
fun Q2(questionNumber: Int, modifier: Modifier = Modifier) {
    RelayText(
        content = "Q ${questionNumber + 1}", // Adding 1 because index starts from 0
        fontSize = 32.0.sp,
        fontFamily = inter,
        color = Color(
            alpha = 255,
            red = 0,
            green = 0,
            blue = 0
        ),
        height = 1.2102272510528564.em,
        textAlign = TextAlign.Left,
        modifier = modifier
    )
}

@Composable
fun GameLogo1(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.q2_question_game_logo_1),
        contentScale = ContentScale.Crop,
        modifier = modifier
            .requiredWidth(100.0.dp)
            .requiredHeight(100.0.dp)
    )
}

@Composable
fun ButtonPlay2(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.q2_question_button_play2),
        modifier = modifier
            .requiredWidth(200.0.dp)
            .requiredHeight(65.0.dp)
    )
}

@Composable
fun ButtonPlay3(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.q2_question_button_play3),
        modifier = modifier
            .requiredWidth(200.0.dp)
            .requiredHeight(65.0.dp)
    )
}

@Composable
fun Exit(modifier: Modifier = Modifier) {
    RelayText(
        content = "Exit",
        fontSize = 32.0.sp,
        fontFamily = inter,
        color = Color(
            alpha = 255,
            red = 0,
            green = 0,
            blue = 0
        ),
        height = 1.2102272510528564.em,
        textAlign = TextAlign.Left,
        modifier = modifier
    )
}

@Composable
fun Restart(modifier: Modifier = Modifier) {
    RelayText(
        content = "Restart",
        fontSize = 32.0.sp,
        fontFamily = inter,
        color = Color(
            alpha = 255,
            red = 0,
            green = 0,
            blue = 0
        ),
        height = 1.2102272510528564.em,
        textAlign = TextAlign.Left,
        modifier = modifier
    )
}

@Composable
fun Pink210x2104(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.q2_question_pink_210x210_1),
        contentScale = ContentScale.Crop,
        modifier = modifier
            .requiredWidth(210.0.dp)
            .requiredHeight(210.0.dp)
    )
}

@Composable
fun Jeans1(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.q2_question_jeans_1),
        contentScale = ContentScale.Crop,
        modifier = modifier
            .requiredWidth(118.0.dp)
            .requiredHeight(86.0.dp)
    )
}

@Composable
fun Factory1(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.q2_question_factory_1),
        contentScale = ContentScale.Crop,
        modifier = modifier
            .requiredWidth(143.0.dp)
            .requiredHeight(131.0.dp)
    )
}

@Composable
fun Disposal1(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.q2_question_disposal_1),
        contentScale = ContentScale.Crop,
        modifier = modifier
            .requiredWidth(139.0.dp)
            .requiredHeight(156.0.dp)
    )
}

@Composable
fun Transport1(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.q2_question_transport_1),
        contentScale = ContentScale.Crop,
        modifier = modifier
            .requiredWidth(143.0.dp)
            .requiredHeight(140.0.dp)
    )
}

@Composable
fun Consumer1(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.q2_question_consumer_1),
        contentScale = ContentScale.Crop,
        modifier = modifier
            .requiredWidth(125.0.dp)
            .requiredHeight(105.0.dp)
    )
}

@Composable
fun Consumer(modifier: Modifier = Modifier) {
    RelayText(
        content = "Consumer",
        fontSize = 20.0.sp,
        fontFamily = inter,
        color = Color(
            alpha = 255,
            red = 0,
            green = 0,
            blue = 0
        ),
        height = 1.2102272033691406.em,
        textAlign = TextAlign.Left,
        maxLines = -1,
        modifier = modifier
            .requiredWidth(108.0.dp)
            .requiredHeight(27.0.dp)
    )
}

@Composable
@Preview
fun ScreenPreview() {

        GameScreen2()

}

@Composable
fun TopLevel(

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


