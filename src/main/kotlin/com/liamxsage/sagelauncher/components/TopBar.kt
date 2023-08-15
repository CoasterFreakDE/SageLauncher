package com.liamxsage.sagelauncher.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.window.WindowDraggableArea
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowScope

@Composable
fun WindowScope.AppWindowTitleBar(onClose: () -> Unit) {
    AppDraggableArea()
    Box(Modifier.fillMaxWidth()) {
        Row(Modifier.align(Alignment.TopStart).padding(horizontal = 8.dp)) {
            Image(
                painterResource("assets/icon/sage-launcher.png"),
                contentDescription = "Logo",
                modifier = Modifier.width(64.dp).fillMaxWidth().padding(top = 8.dp).clipToBounds(),
                alignment = Alignment.TopStart,
                contentScale = ContentScale.Fit,
            )
        }
        Row(Modifier.align(Alignment.TopEnd).padding(horizontal = 8.dp)) {
            IconButton(onClick = onClose) {
                // close button
                Icon(
                    painterResource("assets/icon/x.png"),
                    contentDescription = "Close",
                    modifier = Modifier.width(16.dp).fillMaxWidth().padding(end = 2.dp).clipToBounds(),
                    tint = Color.White,
                )
            }
        }
    }
}

@Composable
private fun WindowScope.AppDraggableArea() = WindowDraggableArea {
    Box(
        Modifier.fillMaxWidth().height(18.dp)/*.offset(y = 2.dp)*/
            .padding(horizontal = 160.dp)
            .shadow(4.dp, RoundedCornerShape(4.dp, 4.dp, 12.dp, 12.dp), ambientColor = Color.White)
            .background(Color.DarkGray)
    )
}