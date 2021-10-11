package com.example.bankly.presentation.screens.PersonalDetailsScreen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.SemanticsProperties.Text
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.example.bankly.R
import org.intellij.lang.annotations.JdkConstants

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
            var isConfirmed by remember {
                mutableStateOf(false)
            }
            var number by remember {
                mutableStateOf(0)
            }

            Column(modifier = Modifier.weight(1f)) {
                TextField(
                    label = "First Name",
                    containerModifier = Modifier.padding(bottom = 10.dp),
                    value = firstName
                ) { value ->
                    firstName = value
                }
                TextField(
                    label = "Last Name",
                    containerModifier = Modifier.padding(bottom = 10.dp),
                    value = lastName
                ) { value ->
                    lastName = value
                }
                PasswordField(label = "Password", value = password, onValueChange = {
                    password = it
                })

                Row(Modifier.padding(top = 10.dp), verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(modifier = Modifier.padding(end = 10.dp)) { isChecked ->
                        isConfirmed = isChecked
                    }
                    Text(buildAnnotatedString {
                        append("I accept the ")
                        withStyle(style = SpanStyle(color = Color.Blue, textDecoration = TextDecoration.Underline)) {
                            append("Terms of service")
                        }
                        append(" and ")
                        withStyle(style = SpanStyle(color = Color.Blue, textDecoration = TextDecoration.Underline)) {
                            append("privacy policy")
                        }
                    })
                }



                RepeatingButton(onClick = { number += 1 } ) {

                }
                Text(text = number.toString())
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