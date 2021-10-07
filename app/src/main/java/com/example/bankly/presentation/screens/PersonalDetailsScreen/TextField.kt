package com.example.bankly.presentation.screens.PersonalDetailsScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextField(containerModifier: Modifier = Modifier, label: String, value: String, onValueChange: (value: String) -> Unit) {
    Column(modifier = containerModifier) {
        Text(
            text = label,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start,
            color = Color.Black,
            fontSize = 18.sp
        )
        BasicTextField(
            modifier = Modifier
                .drawBehind {
                    val strokeWidth = 2f
                    val offsetY = size.height - strokeWidth / 2

                    drawLine(
                        color = Color.Black,
                        Offset(0f, offsetY),
                        Offset(size.width, offsetY),
                        strokeWidth = strokeWidth
                    )
                }
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            value = value,
            singleLine = true,
            onValueChange = {
                value -> onValueChange(value)
            },
        )
    }
}