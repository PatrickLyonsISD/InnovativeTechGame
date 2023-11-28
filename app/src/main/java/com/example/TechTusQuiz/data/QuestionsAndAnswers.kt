
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
    val explanationImage: Int,
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
                text = "What % of a smart phone can be recycled? ",
                options = listOf(
                    Option(text = "80%", image = R.drawable.q2_question_factory_1 ),
                    Option(text = "60%", image = R.drawable.q2_question_disposal_1),
                    Option(text = "40%", image = R.drawable.q2_question_transport_1 ),
                    Option(text = "20%", image = R.drawable.q2_question_consumer_1)
                ),
                correctAnswerIndex = 0,
                explanationImage=R.drawable.a1cellphone,
                explanation = "With newer technology, about 80 percent of the material used in modern cell phones can be recycled or reused when disposed of properly.",
                questionImage = R.drawable.q1_220x220_cellphone,
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
                explanationImage=R.drawable.aq2_220x220_styrofoam,
                explanation = "Styrofoam is not commonly recyclable in most recycling programs. It is a non-biodegradable material that often ends up in landfills. ",
                questionImage = R.drawable.q2_220x220_non_recycle,
                difficulty=Difficulty.Easy
            ),
            Question(
                text = "which of the following is a single use plastic?",
                options = listOf(
                    Option(text = "Plastic Grocery Bag", image = R.drawable.q2_question_factory_1 ),
                    Option(text = "Plastic Water Bottle", image = R.drawable.q2_question_disposal_1),
                    Option(text = "Silicone Baking Mat", image = R.drawable.q2_question_transport_1 ),
                    Option(text = "Tupperware Container", image = R.drawable.q2_question_consumer_1)
                ),
                correctAnswerIndex = 0,
                explanationImage=R.drawable.aq3_220x220_plasticbag,
                explanation = "Plastic Grocery Bags are typically used once before disposal and are a major contributor to plastic waste. Many places have started to ban their use or charge a fee for them to encourage the use of a reusable bag.",
                questionImage = R.drawable.q3_220x220_plasticbag,
                difficulty=Difficulty.Easy
            ),
            Question(
                text = "How many tonnes of microplastics (microfibre pollution) get released into the oceans every year?",
                options = listOf(
                    Option(text = "55,000", image = R.drawable.q3_question_pink_210x210_1),
                    Option(text = "150,000", image = R.drawable.q3_question_plastic541_1),
                    Option(text = "350,000", image = R.drawable.q3_question_styrofoam_1),
                    Option(text = "500,000", image = R.drawable.q3_question_glass_640x380_1)
                ),
                correctAnswerIndex = 3,
                explanationImage=R.drawable.aq4_220x220_tonnes,
                explanation = "http://sdgsforall.ie/wp-content/uploads/2020/06/WVI_SustainableFashion_051320-1.pdf \n" +
                        "\n" +
                        "Most recent research shows that 500,000 tonnes of microfibres (equivalent to 50billion plastic bottles4) are released into the oceans every year (microfibre pollution). ",
                questionImage = R.drawable.q4_220x220_microplastics,
                difficulty=Difficulty.Easy
            ),
            Question(
                text = "Which phase of a textile’s lifecycle releases the most greenhouse gasses?",
                options = listOf(
                    Option(text = "Transportation", image = R.drawable.q2_question_factory_1 ),
                    Option(text = "Disposal", image = R.drawable.q2_question_disposal_1),
                    Option(text = "Manufacturing", image = R.drawable.q2_question_transport_1 ),
                    Option(text = "Consumer", image = R.drawable.q2_question_consumer_1)
                ),
                correctAnswerIndex = 0,
                explanationImage=R.drawable.q3_question_reuse_1,
                explanation = "https://climateseed.com/blog/secteur-du-textile-impact-environnemental-et-r%C3%A9glementation \n" +
                        "\n" +
                        "Transportation is involved in and between every stage of the clothing life cycle. The clothing supply chain is global and air freight if it is used, causes significant contributions to GHG emissions.",
                questionImage = R.drawable.q2_question_jeans_1,
                difficulty=Difficulty.Medium
            ),
            Question(
                text = "How many litres of water does it take to make 1 cotton T-Shirt?",
                options = listOf(
                    Option(text = "27", image = R.drawable.q3_question_pink_210x210_1),
                    Option(text = "270", image = R.drawable.q3_question_plastic541_1),
                    Option(text = "2,700", image = R.drawable.q3_question_styrofoam_1),
                    Option(text = "27,000", image = R.drawable.q3_question_glass_640x380_1)
                ),
                correctAnswerIndex = 2,
                explanationImage=R.drawable.q3_question_reuse_1,
                explanation = "http://sdgsforall.ie/wp-content/uploads/2020/06/WVI_SustainableFashion_051320-1.pdf \n" +
                        "\n" +
                        "Cotton contributes to the global freshwater shortage due to the vast quantities required during farming and production. It can take approximately 2,700 litres of water to produce one cotton t-shirt.",
                questionImage = R.drawable.q6_220x220_waterlitre,
                difficulty=Difficulty.Medium
            ),
            Question(
                text = "Which action can significantly reduce the impact of single-use plastics on the environment?",
                options = listOf(
                    Option(text = "Reusing them for the same purpose", image = R.drawable.q2_question_factory_1 ),
                    Option(text = "Using paper-based alternatives", image = R.drawable.q2_question_disposal_1),
                    Option(text = "Recycling them where facilities exist", image = R.drawable.q2_question_transport_1 ),
                    Option(text = "Burning them for heat", image = R.drawable.q2_question_consumer_1)
                ),
                correctAnswerIndex = 0,
                explanationImage=R.drawable.q3_question_reuse_1,
                explanation = "Reusing single-use plastics for the same or other purposes can help reduce the demand for new plastics and minimize waste. While not all single-use plastics can be recycled, reusing them when possible is a direct action that can lessen environmental impact.",
                questionImage = R.drawable.q7_220x220_thinkgreen,
                difficulty=Difficulty.Medium
            ),
            Question(
                text = "What is the estimated time it takes for a single-use plastic bottle to decompose in a marine environment?",
                options = listOf(
                    Option(text = "Up to 50 years", image = R.drawable.q3_question_pink_210x210_1),
                    Option(text = "Up to 100 years", image = R.drawable.q3_question_plastic541_1),
                    Option(text = "Up to 450 years", image = R.drawable.q3_question_styrofoam_1),
                    Option(text = "Up to 1000 years", image = R.drawable.q3_question_glass_640x380_1)
                ),
                correctAnswerIndex = 2,
                explanationImage=R.drawable.q3_question_reuse_1,
                explanation = "Plastic bottles are made of PET (polyethylene terephthalate), which is highly durable and resistant to decomposition. In marine environments, these bottles can take up to 450 years to decompose, leading to long-term pollution and harm to marine life.",
                questionImage = R.drawable.q8_220x220_seawaste,
                difficulty=Difficulty.Medium
            ),
            Question(
                text = "How many solar photovoltaic panels are on TUS Moylish campus roof space?",
                options = listOf(
                    Option(text = "None", image = R.drawable.q2_question_factory_1 ),
                    Option(text = "32", image = R.drawable.q2_question_disposal_1),
                    Option(text = "120", image = R.drawable.q2_question_transport_1 ),
                    Option(text = "370", image = R.drawable.q2_question_consumer_1)
                ),
                correctAnswerIndex = 3,
                explanationImage=R.drawable.q3_question_reuse_1,
                explanation = "Transportation is involved in and between every stage of the clothing life cycle. The clothing supply chain is global and air freight, in particular, if it is used, causes significant contributions to GHG emissions, ",
                questionImage = R.drawable.q9_220x220_solarpanels,
                difficulty=Difficulty.Hard
            ),
            Question(
                text = "Of the 17 United Nations Sustainable Development Goals, Goal 11 strives to do which of the following?",
                options = listOf(
                    Option(text = "Reduce Chemical Waste", image = R.drawable.q3_question_pink_210x210_1),
                    Option(text = "Increases productivity and job creation", image = R.drawable.q3_question_plastic541_1),
                    Option(text = "Make cities and human settlements inclusive, safe, resilient and sustainable", image = R.drawable.q3_question_styrofoam_1),
                    Option(text = "Ensure healthy lives and promote well-being for all at all ages", image = R.drawable.q3_question_glass_640x380_1)
                ),
                correctAnswerIndex = 3,
                explanationImage=R.drawable.q3_question_reuse_1,
                explanation = "https://tus.ie/app/uploads/ProfessionalServices/CampusServicesCapitalDev/TUS-Climate-Action-Roadmap-2023-2026.pdf \n" +
                        "\n" +
                        "the electricity generated by the current installation of photovoltaic panels on the Moylish campus which comprises 370 solar photovoltaic panels (166KWp) covering 800m2 roof space and avoiding 64 tons of CO2 emissions annually.",
                questionImage = R.drawable.q10_220x220_greenroof,
                difficulty=Difficulty.Hard
            ),
            Question(
                text = "How can green roofing on college buildings, like those at TUS Moylish, contribute to urban sustainability?",
                options = listOf(
                    Option(text = "By providing additional space for classrooms", image = R.drawable.q2_question_factory_1 ),
                    Option(text = "By reducing building heating and cooling costs", image = R.drawable.q2_question_disposal_1),
                    Option(text = "By increasing the building's weight and stability", image = R.drawable.q2_question_transport_1 ),
                    Option(text = "By attracting more wildlife to the urban area", image = R.drawable.q2_question_consumer_1)
                ),
                correctAnswerIndex = 1,
                explanationImage=R.drawable.q3_question_reuse_1,
                explanation = "Green roofs, covered with vegetation, can significantly reduce heating and cooling costs in buildings. They provide insulation, reducing the need for heating in the winter and cooling in the summer. This contributes to energy efficiency, a key aspect of urban sustainability, particularly in a campus setting like TUS Moylish.",
                questionImage = R.drawable.q11_220x220_unsdg,
                difficulty=Difficulty.Hard
            ),
            Question(
                text = "How many Goals and Targets does the United Nations 2030 Agenda for Sustainable Development have?",
                options = listOf(
                    Option(text = "1 Goal and 1 Target", image = R.drawable.q3_question_pink_210x210_1),
                    Option(text = "10 Goals and 23 Targets", image = R.drawable.q3_question_plastic541_1),
                    Option(text = "17 Goals and 169 Targets", image = R.drawable.q3_question_styrofoam_1),
                    Option(text = "169 Goals and 10 Targets", image = R.drawable.q3_question_glass_640x380_1)
                ),
                explanationImage=R.drawable.q3_question_reuse_1,
                correctAnswerIndex = 2,
                explanation = "The 2030 Agenda for Sustainable Development, adopted by all United Nations Member States in 2015, has 17 Sustainable Development Goals (SDGs) and 169 Targets, which are an urgent call for action by all countries - developed and developing - in a global partnership.",
                questionImage = R.drawable.q12_220x220_sdg11,
                difficulty=Difficulty.Hard
            )


        )
    }
}
