package com.example.dosometin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.lifecycle.ViewModelProvider
import com.example.dosometin.view.DosometinUI
import com.example.dosometin.viewmodel.DoSometinViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DosometinUI()
        }
    }

    override fun onStart() {
        super.onStart()
        val viewModel = ViewModelProvider(this).get(DoSometinViewModel::class.java)
        viewModel.getResponse("","","")
    }
}



