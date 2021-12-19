package com.example.dosometin.view

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.dosometin.ui.theme.gray
import com.example.dosometin.viewmodel.DoSometinViewModel

@SuppressLint("UnrememberedMutableState")
@ExperimentalAnimationApi
@Composable
fun ResultBox(viewModel: DoSometinViewModel = hiltViewModel()){

    var resultText by remember { mutableStateOf("") }
    val isLoading = viewModel.isLoading
    var colorOfResultText by remember{mutableStateOf(Color.White)}

    if(viewModel.getData.error == null){
        colorOfResultText = Color.White
        resultText = viewModel.getData.activity
    } else{
        colorOfResultText = Color.Red
        resultText = viewModel.getData.error!!
    }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.4f),
        color = gray,
        shape = RoundedCornerShape(bottomStart = 40.dp,bottomEnd = 40.dp)
    ){
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(16.dp)
        ) {
            LoadingScreen(isLoading)

            AnimatedVisibility(visible = !isLoading) {
                Text(
                    text = resultText,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorOfResultText,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}