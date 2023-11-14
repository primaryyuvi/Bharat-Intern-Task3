package com.example.quizapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizapp.R
import com.example.quizapp.data.difficulty
import com.example.quizapp.ui.theme.QuizAppTheme

@Composable
fun FirstScreen(
    onclick: (String)->Unit
){
    Box (modifier = Modifier.verticalScroll(rememberScrollState())
        ){
        Image(painter = painterResource(
            id = R.drawable.blue_wall,
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
                    text = "Welcome to Quiz App",
                    //color = MaterialTheme.colorScheme.onSecondaryContainer,
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Choose the below options for each set of questions",
                    textAlign = TextAlign.Center,

                    //color = Color.Black,
                    fontSize = 16.sp
                )
                Text(text = "Don't Google the answer !",
                    //color = Color.Black
                    )
                Row(modifier = Modifier.padding(16.dp)) {
                    Column {
                        difficulty.forEach {
                            SelectionButton(
                                text = it,
                                onclick = { onclick(it) }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun SelectionButton(text : String, onclick : () -> Unit) {
    Button(
        onClick = onclick,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary
        )
    ) {
        Text(
            text = text,
            modifier = Modifier.widthIn(min = 200.dp),
            textAlign = TextAlign.Center

        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview(){
    QuizAppTheme(darkTheme = true) {
        FirstScreen(onclick = {})
    }
}