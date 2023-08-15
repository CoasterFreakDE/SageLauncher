package com.liamxsage.sagelauncher.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

data class Pack(val id: Int, val color: Color)

@Composable
fun PackList(packs: List<Pack>) {
    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Row (Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            packs.forEach { pack ->
                PackDisplay(pack.id, color = pack.color)
            }
        }
    }
}