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

package com.example.TechTusQuiz.data

import android.media.Image
import com.example.unscramble.R

data class Question(

    val text: String,
    val options: List<Option>,
    val correctAnswerIndex: Int,
    val explanation: String,
    val questionImage: Int // Image for the question
    // add in dificulty 3
)

data class Option(
    val text: String,
    val image: Int
)

class QuestionsRepository{
    fun getQuestions(): List<Question>{
        return listOf(
            Question(
                text = "Which phase of a textiles lifecycle releases the most greenhouse gasses?",
                options = listOf(
                    Option(text = "Factory testtesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttest test test test test test", image = R.drawable.q2_question_factory_1 ),
                    Option(text = "Disposal test test test test", image = R.drawable.q2_question_disposal_1),
                    Option(text = "Transport", image = R.drawable.q2_question_transport_1 ),
                    Option(text = "Consumer", image = R.drawable.q2_question_consumer_1)
                ),
                correctAnswerIndex = 2,
                explanation = "Transportation is involved in and between every stage of the clothing life cycle. The clothing supply chain is global and air freight, in particular, if it is used, causes significant contributions to GHG emissions, ",
                questionImage = R.drawable.q2_question_jeans_1
            ),
            Question(
                text = "What material is not included in most recycling programs?",
                options = listOf(
                    Option(text = "Paper", image = R.drawable.q3_question_pink_210x210_1),
                    Option(text = "Plastic", image = R.drawable.q3_question_plastic541_1),
                    Option(text = "Styrofoam", image = R.drawable.q3_question_styrofoam_1),
                    Option(text = "Glass", image = R.drawable.q3_question_glass_640x380_1)
                ),
                correctAnswerIndex = 2,
                explanation = "Styrofoam is not commonly recyclable in most recycling programs. It is a non-biodegradable material that often ends up in landfills. ",
                questionImage = R.drawable.q3_question_reuse_1
            )


        )
    }
}
