package com.example.quizapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.ExtraBold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizapp.R
import com.example.quizapp.ui.theme.QuizAppTheme

@Composable
fun ResultScreen(
answer : Int,
){
    Box (modifier = Modifier.verticalScroll(rememberScrollState())
    ){
        Image(painter = painterResource(
            id = R.drawable.cillian_murphy,
        ),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .scale(1.1f)
        )
        Card(modifier = Modifier
            .align(Alignment.Center)
            .padding(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = MaterialTheme.colorScheme.onSurface
            )
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Thank you for attempting the quiz!",
                    //color = Color.Black,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                )
                Text(
                    text = "Reopen the app to try again",
                    fontSize = 16.sp,
                    //color = Color.Black
                )
                Text(
                    text = "Your score is $answer!",
                    textAlign = TextAlign.Center,
                    //color = Color.Black,
                    fontSize = 38.sp,
                    fontWeight = ExtraBold
                )

                        }
                    }
                }
            }

@Preview
@Composable
fun RPreview() {
    QuizAppTheme(darkTheme = false) {
        ResultScreen(answer = 40)
    }
}
