package com.example.bankly.presentation.screens.PersonalDetailsScreen

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.forEachGesture
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ButtonElevation
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.input.pointer.pointerInput
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun RepeatingButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    elevation: ButtonElevation? = ButtonDefaults.elevation(),
    shape: Shape = MaterialTheme.shapes.small,
    border: BorderStroke? = null,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    maxDelayMillis: Long = 500,
    minDelayMillis: Long = 5,
    delayDecayFactor: Float = .15f,
    content: @Composable RowScope.() -> Unit
) {
    val currentClickListener by rememberUpdatedState(onClick)

    androidx.compose.material.Button(
        modifier = modifier.pointerInput(interactionSource, enabled) {
            forEachGesture {
                coroutineScope {
                    awaitPointerEventScope {
                        val downAction = awaitFirstDown(requireUnconsumed = false)
                        val heldButtonJob = launch {
                            var currentDelayMillis = maxDelayMillis
                            while (enabled && downAction.pressed) {
                                // call updated onClick function for each gesture
                                currentClickListener()
                                delay(currentDelayMillis)
                                // Get next delay by delay decay factor
                                val nextDelayMillis =
                                    currentDelayMillis - (currentDelayMillis * delayDecayFactor)
                                // force the delay to be at least 5ms as the recomposition can be so fast
                                currentDelayMillis =
                                    nextDelayMillis.toLong().coerceAtLeast(minDelayMillis)
                            }
                        }

                        // up or canceled then cancel job (it is a while loop)
                        waitForUpOrCancellation()
                        heldButtonJob.cancel()
                    }
                }
            }
        },
        onClick = {},
        enabled = enabled,
        interactionSource = interactionSource,
        elevation = elevation,
        shape = shape,
        border = border,
        colors = colors,
        contentPadding = contentPadding,
        content = content
    )
}