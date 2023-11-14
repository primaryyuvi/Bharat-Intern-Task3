package com.example.quizapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quizapp.data.Destination
import com.example.quizapp.data.easyQuestions
import com.example.quizapp.data.easyQuestionsAnswers
import com.example.quizapp.data.mediumQuestions
import com.example.quizapp.data.mediumQuestionsAnswers
import com.example.quizapp.data.toughQuestions
import com.example.quizapp.data.toughQuestionsAnswers
import com.example.quizapp.quizViewModel.QuizViewModel
import com.example.quizapp.ui.FirstScreen
import com.example.quizapp.ui.QuestionScreen
import com.example.quizapp.ui.ResultScreen

private fun cancelQuizAndNavigateToStart(
    viewModel: QuizViewModel,
    navController: NavHostController
){
    QuizViewModel.resetOrder(viewModel)
    navController.popBackStack(Destination.optionName,inclusive = false)
}
@Composable
fun QuizAppLayout(
    navController: NavHostController = rememberNavController(),
    quizViewModel: QuizViewModel = viewModel()
) {
        val quizUiState by quizViewModel.uistate.collectAsState()
        NavHost(
            navController = navController,
            startDestination = Destination.optionName,
            modifier = Modifier,
        ) {
            composable(route = Destination.optionName) {
                FirstScreen(
                    onclick = {
                        navController.navigate("Question/$it/0")
                    }
                )
            }
            for (questionIndex in 0..9) {
                composable(route = "Question/Easy/$questionIndex") {
                    val nextRoute = questionIndex + 1
                    val route = if (questionIndex == 9) {
                        Destination.summaryName
                    } else {
                        "Question/Easy/$nextRoute"
                    }
                    QuestionScreen(
                        questionAndOptions = easyQuestions[questionIndex],
                        questionFontSize = 20.sp,
                        onNextButtonClicked = {
                            quizViewModel.isCorrectOrNot(
                                easyQuestionsAnswers[questionIndex]
                            )
                            quizViewModel.calculateProgress()
                            navController.navigate(route)
                        },
                        onCancelButtonClicked = {
                            cancelQuizAndNavigateToStart(quizViewModel, navController)
                        },
                        quizViewModel = quizViewModel
                    )
                }
            }
            for (questionIndex in 0..9) {
                composable(route = "Question/Medium/$questionIndex") {
                    val nextRoute = questionIndex + 1
                    val route = if (questionIndex == 9) {
                        Destination.summaryName
                    } else {
                        "Question/Medium/$nextRoute"
                    }
                    QuestionScreen(
                        questionAndOptions = mediumQuestions[questionIndex],
                        questionFontSize = 20.sp,
                        onNextButtonClicked = {
                            quizViewModel.isCorrectOrNot(
                                mediumQuestionsAnswers[questionIndex]
                            )
                            quizViewModel.calculateProgress()
                            navController.navigate(route)
                        },
                        onCancelButtonClicked = {
                            cancelQuizAndNavigateToStart(quizViewModel, navController)
                        },
                        quizViewModel = quizViewModel
                    )
                }
            }
            for (questionIndex in 0..9) {
                composable(route = "Question/Tough/$questionIndex") {
                    val nextRoute = questionIndex + 1
                    val route = if (questionIndex == 9) {
                        Destination.summaryName
                    } else {
                        "Question/Tough/$nextRoute"
                    }
                    QuestionScreen(
                        questionAndOptions = toughQuestions[questionIndex],
                        questionFontSize = 20.sp,
                        onNextButtonClicked = {
                            quizViewModel.isCorrectOrNot(
                                toughQuestionsAnswers[questionIndex]
                            )
                            quizViewModel.calculateProgress()
                            navController.navigate(route)
                        },
                        onCancelButtonClicked = {
                            cancelQuizAndNavigateToStart(quizViewModel, navController)
                        },
                        quizViewModel = quizViewModel
                    )
                }
            }
            composable(route = Destination.summaryName) {
                ResultScreen(quizUiState.score)
            }
        }
    }