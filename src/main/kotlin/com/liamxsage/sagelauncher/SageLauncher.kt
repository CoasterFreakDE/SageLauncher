package com.liamxsage.sagelauncher

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.liamxsage.sagelauncher.components.AnimatedBackgroundImage
import com.liamxsage.sagelauncher.components.AppWindowTitleBar
import com.liamxsage.sagelauncher.components.PackList
import kotlin.system.exitProcess

@Composable
@Preview
fun App() {
    val images = listOf(
        painterResource("assets/bg/bg1.png"),
        painterResource("assets/bg/bg2.png"),
        painterResource("assets/bg/bg3.png"),
        painterResource("assets/bg/bg4.png"),
        painterResource("assets/bg/bg5.png"),
    )
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize().padding(5.dp).shadow(3.dp, RoundedCornerShape(20.dp)),
            color = Color(55, 55, 55),
            shape = RoundedCornerShape(20.dp)
        ) {
            AnimatedBackgroundImage(images)

            PackList()
        }
    }
}

fun main() = application {
    val state = rememberWindowState(
        position = WindowPosition(Alignment.Center), size = DpSize(1280.dp, 768.dp)
    )
    Window(
        onCloseRequest = ::exitApplication,
        title = "Sage Launcher",
        state = state,
        icon = painterResource("assets/icon/sage-launcher.png"),
        transparent = true,
        undecorated = true,
    ) {
        App()
        AppWindowTitleBar { exitApplication() }
    }

}
