package com.example.quizapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.example.quizapp.R
import com.example.quizapp.data.QuestionAndOptions
import com.example.quizapp.quizViewModel.QuizViewModel


@Composable
fun QuestionScreen(
    questionAndOptions : QuestionAndOptions,
    questionFontSize : TextUnit,
    onNextButtonClicked : () -> Unit,
    onCancelButtonClicked : () -> Unit,
    quizViewModel: QuizViewModel
){
    val quizUiState by quizViewModel.uistate.collectAsState()
    Box (modifier = Modifier.verticalScroll(rememberScrollState())){
        Image(painter = painterResource(id = R.drawable.oceano),
            contentDescription =null,
            modifier = Modifier.scale(2.9f)
            )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxHeight()
        ) {
            Spacer(modifier = Modifier.height(64.dp))
            LinearProgressIndicator(
                progress = quizUiState.progress,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(8.dp),
                trackColor = MaterialTheme.colorScheme.secondaryContainer
            )
            Spacer(modifier = Modifier.height(50.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 16.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    contentColor = MaterialTheme.colorScheme.onSurface
                )
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                )
                {
                    Text(
                        text = questionAndOptions.question,
                        fontSize = questionFontSize,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(16.dp),
                        fontWeight = FontWeight.Bold
                    )
                    Row(
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            OptionsButton(
                                option = questionAndOptions.option1,
                                onclick = {
                                    quizViewModel.inputAnswer(questionAndOptions.option1)
                                }
                            )
                            OptionsButton(
                                option = questionAndOptions.option2,
                                onclick = {
                                    quizViewModel.inputAnswer(questionAndOptions.option2)
                                }
                            )
                            OptionsButton(
                                option = questionAndOptions.option3,
                                onclick = {
                                    quizViewModel.inputAnswer(questionAndOptions.option3)
                                },
                            )
                            OptionsButton(
                                option = questionAndOptions.option4,
                                onclick = {
                                    quizViewModel.inputAnswer(questionAndOptions.option4)
                                },
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(44.dp))
            Row {
                Button(
                    onClick = onCancelButtonClicked
                ) {
                    Text(
                        text = "Cancel",
                        textAlign = TextAlign.Center
                    )
                }
                Spacer(modifier = Modifier.width(40.dp))
                Button(
                    onClick = onNextButtonClicked,
                ) {
                    Text(
                        text = "Next",
                    )
                }
            }
        }
    }
}
@Composable
fun OptionsButton(option : String,onclick : () -> Unit ){
     Button(
         onClick = onclick,
         modifier = Modifier.fillMaxWidth(),
         shape = RoundedCornerShape(8.dp)
     ) {
         Text(
             text = option
         )
     }
}