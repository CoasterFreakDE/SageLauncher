package com.liamxsage.sagelauncher.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun RowScope.PackDisplay(
    packId: Int = 1,
    color: Color = Color.LightGray,
) {
    BoxWithConstraints (
        modifier = Modifier
            .height(400.dp)
            .widthIn(max = 300.dp)
            .background(Color(1, 4, 9, 150), shape = RoundedCornerShape(20.dp))
    ) {
        PackLayout(color = color)
    }
}

@Composable
fun BoxScope.PackLayout(color: Color) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        PackTitleBar(color = color)
        FeatureList()
        Footer(color = color)
    }
}

@Composable
fun ColumnScope.PackTitleBar(color: Color) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color, shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
    ) {
        Text(text = "Pack Title", color = Color.White, modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun ColumnScope.FeatureList() {
    Column(
        modifier = Modifier
            .align(Alignment.Start)
            .padding(16.dp)
            .weight(1F), // It will expand to use any remaining space.
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        // Feature List
        Text(text = "Feature1", color = Color.White)
        Text(text = "Feature2", color = Color.White)
    }
}

@Composable
fun ColumnScope.Footer(color: Color) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.CenterHorizontally)
    ) {
        VersionText()
        ControlButtons(color = color)
    }
}

@Composable
fun ColumnScope.VersionText() {
    Text(
        text = "Version: latest (1.20.1)",
        color = Color.White,
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun ColumnScope.ControlButtons(color: Color) {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
        PlayButton(color = color)
        SpacerBox()
        CustomizeButton()
    }
}

@Composable
fun RowScope.PlayButton(color: Color) {
    Button(
        onClick = { /* Play button action */ },
        modifier = Modifier
            .padding(8.dp)
            .align(Alignment.CenterVertically),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = color, contentColor = Color.White)
    ) {
        Text("Play", color = Color.White)
    }
}

@Composable
fun RowScope.SpacerBox() {
    Box(modifier = Modifier.width(8.dp)) {} // An empty box as a spacer
}

@Composable
fun RowScope.CustomizeButton() {
    IconButton(
        onClick = { /* Customize button action */ },
        modifier = Modifier
            .padding(8.dp)
            .align(Alignment.CenterVertically)
    ) {
        Row {
            Icon(
                painter = painterResource("assets/icon/customize.png"),
                contentDescription = "Customize",
                modifier = Modifier.size(18.dp),
                tint = Color.LightGray
            )
            Text(" Customize", color = Color.White)
        }
    }
}