package com.example.dosometin.view

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.dosometin.R
import com.example.dosometin.ui.theme.background
import com.example.dosometin.ui.theme.pink
import com.example.dosometin.viewmodel.DoSometinViewModel

@ExperimentalAnimationApi
@Composable
fun SelectorPanel(viewModel: DoSometinViewModel = hiltViewModel()){

    val activityType = stringArrayResource(id = R.array.activity_types)
    val activityParticipants = stringArrayResource(id = R.array.activity_participants)
    val activityAccessibility = stringArrayResource(id = R.array.activity_accessibility)

    var type by remember { mutableStateOf("") }
    var participants by remember { mutableStateOf("") }
    var accessibility by remember { mutableStateOf("") }

    val context = LocalContext.current

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        color = background
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.padding(vertical = 20.dp))
            Row{
                type = dropDownMenu(activityType,"TYPE")
                Spacer(modifier = Modifier.padding(horizontal = 10.dp))
                participants = dropDownMenu(activityParticipants,label = "PARTICIPANTS")
            }
            Spacer(modifier = Modifier.padding(vertical = 10.dp))
            Row {
                accessibility = dropDownMenu(activityAccessibility,label = "ACCESSIBILITY")
            }

            Spacer(modifier = Modifier.padding(vertical = 30.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                FloatingActionButton(
                    backgroundColor = pink,
                    modifier = Modifier
                        .scale(1.2f),
                    onClick = {
                        viewModel.getResponse(type,participants,accessibility,context)
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "" ,
                        tint = background
                    )
                }
            }
        }
    }
}