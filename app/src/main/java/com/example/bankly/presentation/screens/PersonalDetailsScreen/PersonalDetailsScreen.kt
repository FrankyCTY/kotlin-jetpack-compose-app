package com.example.bankly.presentation.screens.PersonalDetailsScreen

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankly.R

@Composable
fun PersonalDetailsScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp)
                .padding(bottom = 30.dp)
        ) {
            var firstName by remember {
                mutableStateOf("")
            }
            var lastName by remember {
                mutableStateOf("")
            }
            var password by remember {
                mutableStateOf("")
            }

            Column(modifier = Modifier.weight(1f)) {
                TextField(
                    label = "First Name",
                    containerModifier = Modifier.padding(bottom = 10.dp),
                    value = firstName
                ) { value ->
                    firstName = value
                }
                TextField(label = "Last Name", containerModifier = Modifier.padding(bottom = 10.dp), value = lastName) { value ->
                    lastName = value
                }
                PasswordField(label = "Password", value = password, onValueChange = {
                    password = it
                })
            }

            Button(label = "Next", SuffixIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_right_arrow),
                    contentDescription = "next"
                )
            }) {
                Log.d("tag", "hello")
            }
        }
    }
}