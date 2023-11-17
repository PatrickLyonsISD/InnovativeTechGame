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
                    Option(text = "Factory", image = R.drawable.q2_question_factory_1 ),
                    Option(text = "Disposal", image = R.drawable.q2_question_disposal_1),
                    Option(text = "Transport", image = R.drawable.q2_question_transport_1 ),
                    Option(text = "Consumer", image = R.drawable.q2_question_consumer_1)
                ),
                correctAnswerIndex = 2,
                explanation = "Transportation is involved in and between every stage of the clothing life cycle. The clothing supply chain is global and air freight, in particular, if it is used, causes significant contributions to GHG emissions, ",
                questionImage = R.drawable.q2_question_jeans_1
            )
        )
    }
}
