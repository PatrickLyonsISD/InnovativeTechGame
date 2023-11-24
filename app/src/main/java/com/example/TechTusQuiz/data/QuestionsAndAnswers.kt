
package com.example.TechTusQuiz.data

import android.media.Image
import com.example.unscramble.R

enum class Difficulty{
    Easy, Medium, Hard
}

enum class UserProgress{
    Eco_Novice, Eco_Apprentice,Eco_Master,In_Progress
}
data class Question(

    val text: String,
    val options: List<Option>,
    val correctAnswerIndex: Int,
    val explanation: String,
    val questionImage: Int, // Image for the question
    val difficulty: Difficulty
)

data class Option(
    val text: String,
    val image: Int
)

class QuestionsRepository{
    fun getQuestions(): List<Question>{
        return listOf(
            Question(
                text = "Which phase of a textiles lifecycle releases the most greenhouse gases? taragak taragak taragak taragak taragak taragak taragak taragak taragak taragak taragak taragak taragak taragak taragak taragak taragak taragak taragak taragak taragak taragak taragak taragak taragak taragak taragak taragak taragak taragak taragak taragak taragak taragak taragak taragak taragak taragak taragak",
                options = listOf(
                    Option(text = "Factory", image = R.drawable.q2_question_factory_1 ),
                    Option(text = "Disposal", image = R.drawable.q2_question_disposal_1),
                    Option(text = "Transport", image = R.drawable.q2_question_transport_1 ),
                    Option(text = "Consumer", image = R.drawable.q2_question_consumer_1)
                ),
                correctAnswerIndex = 2,
                explanation = "Transportation is involved in and between every stage of the clothing life cycle. The clothing supply chain is global and air freight, in particular, if it is used, causes significant contributions to GHG emissions, ",
                questionImage = R.drawable.q2_question_jeans_1,
                        difficulty=Difficulty.Easy
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
                questionImage = R.drawable.q3_question_reuse_1,
                difficulty=Difficulty.Easy
            ),
            Question(
                text = "Placeholder Q3",
                options = listOf(
                    Option(text = "Answer Q3 1", image = R.drawable.q2_question_factory_1 ),
                    Option(text = "Answer Q3 2", image = R.drawable.q2_question_disposal_1),
                    Option(text = "Answer Q3 3", image = R.drawable.q2_question_transport_1 ),
                    Option(text = "Answer Q3 4", image = R.drawable.q2_question_consumer_1)
                ),
                correctAnswerIndex = 2,
                explanation = "Transportation is involved in and between every stage of the clothing life cycle. The clothing supply chain is global and air freight, in particular, if it is used, causes significant contributions to GHG emissions, ",
                questionImage = R.drawable.q2_question_jeans_1,
                difficulty=Difficulty.Easy
            ),
            Question(
                text = "Placeholder Q4",
                options = listOf(
                    Option(text = "Answer Q4 1", image = R.drawable.q3_question_pink_210x210_1),
                    Option(text = "Answer Q4 2", image = R.drawable.q3_question_plastic541_1),
                    Option(text = "Answer Q4 3", image = R.drawable.q3_question_styrofoam_1),
                    Option(text = "Answer Q4 4", image = R.drawable.q3_question_glass_640x380_1)
                ),
                correctAnswerIndex = 2,
                explanation = "Styrofoam is not commonly recyclable in most recycling programs. It is a non-biodegradable material that often ends up in landfills. ",
                questionImage = R.drawable.q3_question_reuse_1,
                difficulty=Difficulty.Easy
            ),
            Question(
                text = "Placeholder Q5",
                options = listOf(
                    Option(text = "Answer Q5 1", image = R.drawable.q2_question_factory_1 ),
                    Option(text = "Answer Q5 2", image = R.drawable.q2_question_disposal_1),
                    Option(text = "Answer Q5 3", image = R.drawable.q2_question_transport_1 ),
                    Option(text = "Answer Q5 4", image = R.drawable.q2_question_consumer_1)
                ),
                correctAnswerIndex = 2,
                explanation = "Transportation is involved in and between every stage of the clothing life cycle. The clothing supply chain is global and air freight, in particular, if it is used, causes significant contributions to GHG emissions, ",
                questionImage = R.drawable.q2_question_jeans_1,
                difficulty=Difficulty.Medium
            ),
            Question(
                text = "Placeholder Q6",
                options = listOf(
                    Option(text = "Answer Q6 1", image = R.drawable.q3_question_pink_210x210_1),
                    Option(text = "Answer Q6 2", image = R.drawable.q3_question_plastic541_1),
                    Option(text = "Answer Q6 3", image = R.drawable.q3_question_styrofoam_1),
                    Option(text = "Answer Q6 4", image = R.drawable.q3_question_glass_640x380_1)
                ),
                correctAnswerIndex = 2,
                explanation = "Styrofoam is not commonly recyclable in most recycling programs. It is a non-biodegradable material that often ends up in landfills. ",
                questionImage = R.drawable.q3_question_reuse_1,
                difficulty=Difficulty.Medium
            ),
            Question(
                text = "Placeholder Q7",
                options = listOf(
                    Option(text = "Answer Q7 1", image = R.drawable.q2_question_factory_1 ),
                    Option(text = "Answer Q7 2", image = R.drawable.q2_question_disposal_1),
                    Option(text = "Answer Q7 3", image = R.drawable.q2_question_transport_1 ),
                    Option(text = "Answer Q7 4", image = R.drawable.q2_question_consumer_1)
                ),
                correctAnswerIndex = 2,
                explanation = "Transportation is involved in and between every stage of the clothing life cycle. The clothing supply chain is global and air freight, in particular, if it is used, causes significant contributions to GHG emissions, ",
                questionImage = R.drawable.q2_question_jeans_1,
                difficulty=Difficulty.Medium
            ),
            Question(
                text = "Placeholder Q8",
                options = listOf(
                    Option(text = "Answer Q8 1", image = R.drawable.q3_question_pink_210x210_1),
                    Option(text = "Answer Q8 2", image = R.drawable.q3_question_plastic541_1),
                    Option(text = "Answer Q8 3", image = R.drawable.q3_question_styrofoam_1),
                    Option(text = "Answer Q8 4", image = R.drawable.q3_question_glass_640x380_1)
                ),
                correctAnswerIndex = 2,
                explanation = "Styrofoam is not commonly recyclable in most recycling programs. It is a non-biodegradable material that often ends up in landfills. ",
                questionImage = R.drawable.q3_question_reuse_1,
                difficulty=Difficulty.Medium
            ),
            Question(
                text = "Placeholder Q9",
                options = listOf(
                    Option(text = "Answer Q9 1", image = R.drawable.q2_question_factory_1 ),
                    Option(text = "Answer Q9 2", image = R.drawable.q2_question_disposal_1),
                    Option(text = "Answer Q9 3", image = R.drawable.q2_question_transport_1 ),
                    Option(text = "Answer Q9 4", image = R.drawable.q2_question_consumer_1)
                ),
                correctAnswerIndex = 2,
                explanation = "Transportation is involved in and between every stage of the clothing life cycle. The clothing supply chain is global and air freight, in particular, if it is used, causes significant contributions to GHG emissions, ",
                questionImage = R.drawable.q2_question_jeans_1,
                difficulty=Difficulty.Hard
            ),
            Question(
                text = "Placeholder Q10",
                options = listOf(
                    Option(text = "Answer Q10 1", image = R.drawable.q3_question_pink_210x210_1),
                    Option(text = "Answer Q10 2", image = R.drawable.q3_question_plastic541_1),
                    Option(text = "Answer Q10 3", image = R.drawable.q3_question_styrofoam_1),
                    Option(text = "Answer Q10 4", image = R.drawable.q3_question_glass_640x380_1)
                ),
                correctAnswerIndex = 2,
                explanation = "Styrofoam is not commonly recyclable in most recycling programs. It is a non-biodegradable material that often ends up in landfills. ",
                questionImage = R.drawable.q3_question_reuse_1,
                difficulty=Difficulty.Hard
            ),
            Question(
                text = "Placeholder Q11",
                options = listOf(
                    Option(text = "Answer Q11 1", image = R.drawable.q2_question_factory_1 ),
                    Option(text = "Answer Q11 2", image = R.drawable.q2_question_disposal_1),
                    Option(text = "Answer Q11 3", image = R.drawable.q2_question_transport_1 ),
                    Option(text = "Answer Q11 4", image = R.drawable.q2_question_consumer_1)
                ),
                correctAnswerIndex = 2,
                explanation = "Transportation is involved in and between every stage of the clothing life cycle. The clothing supply chain is global and air freight, in particular, if it is used, causes significant contributions to GHG emissions, ",
                questionImage = R.drawable.q2_question_jeans_1,
                difficulty=Difficulty.Hard
            ),
            Question(
                text = "Placeholder Q12",
                options = listOf(
                    Option(text = "Answer Q12 1", image = R.drawable.q3_question_pink_210x210_1),
                    Option(text = "Answer Q12 2", image = R.drawable.q3_question_plastic541_1),
                    Option(text = "Answer Q12 3", image = R.drawable.q3_question_styrofoam_1),
                    Option(text = "Answer Q12 4", image = R.drawable.q3_question_glass_640x380_1)
                ),
                correctAnswerIndex = 2,
                explanation = "Styrofoam is not commonly recyclable in most recycling programs. It is a non-biodegradable material that often ends up in landfills. ",
                questionImage = R.drawable.q3_question_reuse_1,
                difficulty=Difficulty.Hard
            )


        )
    }
}
