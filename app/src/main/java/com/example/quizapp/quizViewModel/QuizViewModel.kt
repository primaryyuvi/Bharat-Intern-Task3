package com.example.quizapp.quizViewModel


import androidx.lifecycle.ViewModel
import com.example.quizapp.data.AnswerOptions
import com.example.quizapp.data.QuizUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class QuizViewModel : ViewModel() {

    private var _uistate = MutableStateFlow(QuizUiState())
    val uistate : StateFlow<QuizUiState> = _uistate.asStateFlow()

    fun calculateProgress(){
        _uistate.value.completedQuestions++
        _uistate.value.progress = (_uistate.value.completedQuestions/10.0).toFloat()
    }


    fun inputAnswer(newValue: String){
        _uistate.value.correct = newValue
    }


    fun isCorrectOrNot(
        specificQ : AnswerOptions
    ){
        if(specificQ.answer == _uistate.value.correct)
            _uistate.value.score += 10
    }


    companion object {
        fun resetOrder(quizViewModel: QuizViewModel) {
            quizViewModel._uistate.value = QuizUiState(score = 0, completedQuestions = 0, progress = 0.0f, correct = "")
        }
    }

}