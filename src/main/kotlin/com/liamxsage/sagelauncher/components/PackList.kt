package com.liamxsage.sagelauncher.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.liamxsage.sagelauncher.settings.data.PackSettings


@Composable
fun PackList(packs: List<PackSettings>) {
    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Row (Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            packs.forEach { pack ->
                PackDisplay(pack)
            }
        }
    }
}