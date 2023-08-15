package com.liamxsage.sagelauncher.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

@Composable
fun AnimatedBackgroundImage(images: List<Painter>) {
    val currentImage = remember { mutableStateOf(images.random()) }

    LaunchedEffect(Unit) {
        while(true) {
            delay(5.seconds)
            currentImage.value = images.random()
        }
    }

    AnimatedVisibility(
        visible = true,
        enter = fadeIn(),
        exit = fadeOut()
    ) {
        Crossfade(targetState = currentImage.value) { targetImage ->
            Image(
                painter = targetImage,
                contentDescription = "Background Image",  // This is for accessibility, can be null
                contentScale = ContentScale.FillBounds,  // This will scale the image to fill the Surface
                modifier = Modifier.fillMaxSize().blur(5.dp),
            )
        }
    }
}