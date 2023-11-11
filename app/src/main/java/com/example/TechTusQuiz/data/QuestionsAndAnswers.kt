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

data class Question(
    val text: String,
    val options: List<String>,
    val correctAnswerIndex: Int,
    val Explanation: String
)

class QuestionsRepository{
    fun getQuestions(): List<Question>{
        return listOf(
            Question(
                text="Which of the following is a single use plastic?",
                options= listOf("Plastic grocery bag", "Reusable water bottle", "Silicone baking mat", "Tupperware container"),
                correctAnswerIndex = 0,
                Explanation = "Plastic grocery bags are typically used once test explanation 1"
            ),
            Question(
                text = "What can be a sustainable alternative to single-use plastic straws?",
                options = listOf("Paper straws", "PVC piping", "Plastic stirrers", "Straws made from ivory"),
                correctAnswerIndex = 0,
                Explanation = "Plastic grocery bags are typically used once explanation 2"
            ),
            Question(
                text = "Which action can significantly reduce the impact of single-use plastics on the environment?",
                options = listOf("Reusing them for the same purpose", "Throwing them into any bin available", "Recycling them where facilities exist", "Burning them for heat"),
                correctAnswerIndex = 0,
                Explanation = "Plastic grocery bags are typically used once explanation 3"
            ),
            Question(
                text = "Why are single-use plastics a problem for marine life?",
                options = listOf("They can be mistaken for food and ingested, causing harm or death", "They provide too much food for marine animals", "They increase the water temperature", "They act as homes for aquatic plants"),
                correctAnswerIndex = 0,
                Explanation = "Plastic grocery bags are typically used once explanation 4"
            )
        )
    }
}
