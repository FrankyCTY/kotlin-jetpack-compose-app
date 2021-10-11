package com.example.bankly.presentation.screens.PersonalDetailsScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp

@Composable
fun Checkbox(modifier: Modifier = Modifier, onToggle: (isChecked: Boolean) -> Unit) {
    var isChecked by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = modifier
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = {
                        onToggle(!isChecked)
                        isChecked = !isChecked
                    }
                )
            }
            .clip(CircleShape)
            .size(20.dp)
            .border(2.dp, Color.Black, CircleShape)
            .background(Color.White)
            .padding(4.dp)
            .clip(
                CircleShape
            )
            .background(if (isChecked) Color.Black else Color.White),
        contentAlignment = Alignment.Center
    )
    {
        Icon(
            imageVector = Icons.Default.Check,
            contentDescription = "",
            tint = Color.Transparent
        )
    }
}