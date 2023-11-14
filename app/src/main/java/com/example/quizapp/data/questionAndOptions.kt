package com.example.quizapp.data


data class QuestionAndOptions(
    val question : String,
    val option1 : String,
    val option2: String,
    val option3 : String,
    val option4 : String
)
val difficulty = listOf(
    "Easy",
    "Medium",
    "Tough"
)

data class AnswerOptions(
    val answer : String
)
object Destination{
    const val optionName = "option"
    const val questionName = "Question/{option}/{questionIndex}"
    const val summaryName = "Summary"
}