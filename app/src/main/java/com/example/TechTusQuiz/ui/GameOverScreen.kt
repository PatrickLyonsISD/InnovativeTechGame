package com.example.TechTusQuiz.ui


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.unscramble.R
import com.example.unscramble.frame27.inter
import com.google.relay.compose.CrossAxisAlignment
import com.google.relay.compose.MainAxisAlignment
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayContainerArrangement
import com.google.relay.compose.RelayContainerScope
import com.google.relay.compose.RelayImage
import com.google.relay.compose.RelayText
import com.google.relay.compose.RelayVector
import com.google.relay.compose.relayDropShadow

/**
 * GameOver Screen
 *
 * This composable was generated from the UI Package 'frame_27'.
 * Generated code; do not edit directly
 */
@Composable
fun Frame27(navController: NavController, gameViewModel: QuizViewModel, currentScore: Int, modifier: Modifier = Modifier) {
    TopLevel4(modifier = modifier) {
        Frame26 {
            WinScreen {
                WinScreenSynth {
                    Frame28 {
                        Frame24 {
                            Frame23 {
                                Frame22 {
                                    Frame21 {
                                        Frame20 {
                                            GameLogo4(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                                        }
                                    }
                                }
                            }
                        }
                    }
                    Frame30(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)) {
                        Frame29(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f)) {
                            Rectangle4(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                        }
                    }
                    Frame25(modifier = Modifier.rowWeight(1.0f)) {
                        ButtonPlay4()
                    }
                }
                ThanksForPlaying(
                    modifier = Modifier.boxAlign(
                        alignment = Alignment.TopStart,
                        offset = DpOffset(
                            x = 88.0.dp,
                            y = 344.0.dp
                        )
                    )
                )
                YourFinalScoreWas(score = currentScore,
                    modifier = Modifier.boxAlign(
                        alignment = Alignment.TopStart,
                        offset = DpOffset(
                            x = 74.0.dp,
                            y = 495.0.dp
                        )
                    )
                )
                PlayAgain(
                    onClick = {
                        gameViewModel.resetGame() // Reset the game state
                        navController.navigate("gameScreen") { // Navigate to the game screen
                            popUpTo("gameScreen") { inclusive = true } // Clear back stack
                        }
                    },
                    modifier = Modifier
                        .boxAlign(
                            alignment = Alignment.TopStart,
                            offset = DpOffset(x = 162.dp, y = 676.dp)
                        )
                )

            }
        }
    }
}


@Composable
fun GameLogo4(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.frame_27_game_logo_1),
        contentScale = ContentScale.Crop,
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f).relayDropShadow(
            color = Color(
                alpha = 63,
                red = 0,
                green = 0,
                blue = 0
            ),
            borderRadius = 0.0.dp,
            blur = 2.0.dp,
            offsetX = 4.0.dp,
            offsetY = 4.0.dp,
            spread = 0.0.dp
        )
    )
}

@Composable
fun Frame20(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        itemSpacing = 10.0,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(417.0.dp).requiredHeight(220.0.dp)
    )
}

@Composable
fun Frame21(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        itemSpacing = 10.0,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(417.0.dp).requiredHeight(220.0.dp)
    )
}

@Composable
fun Frame22(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        itemSpacing = 10.0,
        clipToParent = false,
        content = content,
        modifier = modifier
    )
}

@Composable
fun Frame23(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        itemSpacing = 10.0,
        clipToParent = false,
        content = content,
        modifier = modifier
    )
}

@Composable
fun Frame24(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        itemSpacing = 10.0,
        clipToParent = false,
        content = content,
        modifier = modifier
    )
}

@Composable
fun Frame28(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        itemSpacing = 10.0,
        clipToParent = false,
        content = content,
        modifier = modifier
    )
}

@Composable
fun Rectangle4(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.frame_27_rectangle_1),
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Frame29(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        itemSpacing = 10.0,
        clipToParent = false,
        content = content,
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun Frame30(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        itemSpacing = 10.0,
        clipToParent = false,
        content = content,
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun ButtonPlay4(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.frame_27_button_play),
        modifier = modifier.requiredWidth(305.0.dp).requiredHeight(81.0.dp)
    )
}

@Composable
fun Frame25(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        itemSpacing = 10.0,
        clipToParent = false,
        content = content,
        modifier = modifier.fillMaxWidth(1.0f)
    )
}

@Composable
fun WinScreenSynth(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        padding = PaddingValues(
            start = 31.0.dp,
            top = 28.0.dp,
            end = 31.0.dp,
            bottom = 28.0.dp
        ),
        itemSpacing = 45.0,
        content = content,
        modifier = modifier.requiredHeight(764.0.dp).alpha(alpha = 100.0f)
    )
}

@Composable
fun ThanksForPlaying(modifier: Modifier = Modifier) {
    RelayText(
        content = "Thanks for Playing!",
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
        maxLines = -1,
        modifier = modifier.requiredWidth(331.0.dp).requiredHeight(56.0.dp)
    )
}

@Composable
fun YourFinalScoreWas(score: Int, modifier: Modifier = Modifier) {
    RelayText(
        content = "Your Final Score was: $score",
        fontSize = 24.0.sp,
        fontFamily = inter,
        color = Color(
            alpha = 255,
            red = 0,
            green = 0,
            blue = 0
        ),
        height = 1.2102272510528564.em,
        textAlign = TextAlign.Left,
        maxLines = -1,
        modifier = modifier.requiredWidth(331.0.dp).requiredHeight(56.0.dp)
    )
}

@Composable
fun PlayAgain(onClick: () -> Unit, modifier: Modifier = Modifier) {
    RelayText(
        content = "Play Again",
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
            .clickable(onClick = onClick)
            .padding(16.dp)
    )
}

@Composable
fun WinScreen(
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
        modifier = modifier.requiredHeight(764.0.dp)
    )
}

@Composable
fun Frame26(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        arrangement = RelayContainerArrangement.Row,
        itemSpacing = 10.0,
        clipToParent = false,
        content = content,
        modifier = modifier
    )
}

@Composable
fun TopLevel4(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        arrangement = RelayContainerArrangement.Row,
        itemSpacing = 10.0,
        clipToParent = false,
        content = content,
        modifier = modifier
    )
}
@Preview
@Composable
private fun Frame27Preview() {
    MaterialTheme {
        com.example.unscramble.frame27.Frame27()
    }
}