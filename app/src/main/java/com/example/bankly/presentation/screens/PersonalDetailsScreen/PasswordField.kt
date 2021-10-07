package com.example.bankly.presentation.screens.PersonalDetailsScreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.bankly.R

@Composable
fun PasswordField(
    containerModifier: Modifier = Modifier,
    label: String,
    value: String,
    onValueChange: (value: String) -> Unit,
) {
    var passwordVisibility by remember {
        mutableStateOf(false)
    }


    Column(modifier = containerModifier) {
        Text(
            text = label,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start,
            color = Color.Black,
            fontSize = 18.sp
        )
        BoxWithConstraints(modifier = Modifier.fillMaxWidth()) {
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
                onValueChange = { value ->
                    onValueChange(value)
                },
                visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            )
            IconButton(modifier = Modifier.absoluteOffset(maxWidth - 50.dp, -(15.dp)).zIndex(2f), onClick = {
                passwordVisibility = !passwordVisibility
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_open_eye),
                    contentDescription = "click to show password"
                )
            }
        }

    }
}