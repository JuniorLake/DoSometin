package com.example.dosometin.view

import android.annotation.SuppressLint
import androidx.compose.animation.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.dosometin.ui.theme.background

@ExperimentalAnimationApi
@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun DosometinUI() {

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = background
    ) {
        Column(modifier = Modifier.fillMaxSize()){
            Column(verticalArrangement = Arrangement.Top) {
                ResultBox()
            }
            Column(verticalArrangement = Arrangement.Bottom) {
                SelectorPanel()
            }
        }
    }
}