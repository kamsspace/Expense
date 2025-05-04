package com.kamsspace.expense

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp

@Composable
fun MicButton(isListening: Boolean, onClick: () -> Unit) {

    // Transition is used for pulsating the size of the mic for 700 milliseconds repeatedly
    val transition = rememberInfiniteTransition(label = "mic pulse")
    val scaleWhileListening by transition.animateFloat(
        initialValue = 1f, targetValue = 1.5f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 2000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "mic scale"
    )

    val scaleWhileOnStop by transition.animateFloat(
        initialValue = 1f, targetValue = 1.1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "mic scale"
    )

//    animateFloatAsState(if (isListening) 1.5f else 1f)

    val finalScale = if (isListening) scaleWhileListening else scaleWhileOnStop

    Box(
        modifier = Modifier
            .size(100.dp)
            .graphicsLayer { scaleX = finalScale; scaleY = finalScale }
            .clip(CircleShape)
            .background(if (isListening) Color.Blue else Color.Gray)
            .clickable{ onClick() }
    ) {
        Icon(
            imageVector = Icons.Default.Face,
            contentDescription = "Listen",
            tint = Color.Green,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}
