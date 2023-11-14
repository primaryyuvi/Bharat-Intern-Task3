package com.example.quizapp.data

data class QuizUiState(
    var completedQuestions : Int = 0,
    var progress : Float = 0.0f,
    var score : Int = 0,
    var correct : String = ""
)
