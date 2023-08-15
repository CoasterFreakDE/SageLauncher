package com.liamxsage.sagelauncher.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun PackList() {
    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Row (Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {

            PackDisplay(1, color = Color(50, 255, 126, 200))
            PackDisplay(2, color = Color(24, 220, 255, 200))
            PackDisplay(3, color = Color(255, 204, 204, 200))

        }
    }
}