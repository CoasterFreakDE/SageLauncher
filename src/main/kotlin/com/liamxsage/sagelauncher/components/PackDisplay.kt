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
import androidx.compose.ui.unit.sp
import com.liamxsage.sagelauncher.data.PackSettings

@Composable
fun RowScope.PackDisplay(
    pack: PackSettings
) {
    BoxWithConstraints (
        modifier = Modifier
            .height(400.dp)
            .widthIn(max = 300.dp)
            .background(Color(1, 4, 9, 150), shape = RoundedCornerShape(20.dp))
    ) {
        PackLayout(pack)
    }
}

@Composable
fun BoxScope.PackLayout(pack: PackSettings) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        PackTitleBar(pack)
        Description(pack)
        FeatureList(pack)
        Footer(pack)
    }
}

@Composable
fun ColumnScope.PackTitleBar(pack: PackSettings) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(pack.color, shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
    ) {
        Text(text = pack.title, color = Color.White, modifier = Modifier.padding(16.dp), textAlign = TextAlign.Center, fontSize = 20.sp)
    }
}

@Composable
fun ColumnScope.Description(pack: PackSettings) {
    Column(
        modifier = Modifier
            .align(Alignment.Start)
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        // Description
        Text(text = pack.description, color = Color.LightGray, textAlign = TextAlign.Justify, fontSize = 12.sp)
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ColumnScope.FeatureList(pack: PackSettings) {
    Column(
        modifier = Modifier
            .align(Alignment.Start)
            .padding(10.dp)
            .weight(1F), // It will expand to use any remaining space.
        verticalArrangement = Arrangement.spacedBy(1.dp)
    ) {
        // Feature List
        pack.features.forEach { feature ->
            ListItem(
                text = { Text(text = feature, color = Color.White, textAlign = TextAlign.Justify, fontSize = 12.sp, lineHeight = 1.sp) },
                icon = { Icon(painterResource("assets/icon/check.png"), contentDescription = "Check", tint = Color.White, modifier = Modifier.size(12.dp)) },
                modifier = Modifier.padding(start = 3.dp)
            )
        }
    }
}

@Composable
fun ColumnScope.Footer(pack: PackSettings) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.CenterHorizontally)
    ) {
        VersionText(pack)
        ControlButtons(pack)
    }
}

@Composable
fun ColumnScope.VersionText(pack: PackSettings) {
    val versionText = if (pack.selectedVersion == "latest") {
        "Version: latest (1.20.1)" // Todo: Get latest version from server
    } else {
        "Version: ${pack.selectedVersion}"
    }

    Text(
        text = versionText,
        color = Color.White,
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun ColumnScope.ControlButtons(pack: PackSettings) {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
        PlayButton(pack)
        SpacerBox()
        CustomizeButton(pack)
    }
}

@Composable
fun RowScope.PlayButton(pack: PackSettings) {
    Button(
        onClick = { /* Play button action */ },
        modifier = Modifier
            .padding(8.dp)
            .align(Alignment.CenterVertically),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = pack.color, contentColor = Color.White)
    ) {
        Text("Play", color = Color.White)
    }
}

@Composable
fun RowScope.SpacerBox() {
    Box(modifier = Modifier.width(8.dp)) {} // An empty box as a spacer
}

@Composable
fun RowScope.CustomizeButton(pack: PackSettings) {
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