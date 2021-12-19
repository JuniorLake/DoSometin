package com.example.dosometin.view

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dosometin.ui.theme.background
import com.example.dosometin.ui.theme.pink

@ExperimentalAnimationApi
@Composable
fun dropDownMenu(stringArray: Array<String>? = null,label: String? = null): String {

    var expended by remember { mutableStateOf(false) }
    var selected by remember { mutableStateOf("Random") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (label != null) {
            Text(
                text = label,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 13.sp
            )
        }

        TextField(
            shape = RoundedCornerShape(40.dp),
            readOnly = true,
            textStyle = TextStyle(
                fontWeight = FontWeight.Bold,
                color = background,
                textAlign = TextAlign.Center
            ),
            modifier = Modifier
                .width(150.dp)
            ,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = pink,
                focusedIndicatorColor = Color.Transparent,
                cursorColor = background
            ),
            value = selected ,
            onValueChange = { selected = it},
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "Open and Close dropdown menu",
                    tint = background,
                    modifier = Modifier
                        .clickable {
                            expended = !expended
                        }
                        .scale(scaleX = 1f, scaleY = if (expended) -1f else 1f)
                )
            }
        )

        DropdownMenu(
            expanded = expended,
            onDismissRequest = { expended = false}
        ) {
            stringArray?.forEach { item ->
                DropdownMenuItem(onClick = {
                    selected = item
                    expended = !expended
                }) {
                    Text(text = item)
                }
            }
        }
    }
    return selected
}