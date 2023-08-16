package com.liamxsage.sagelauncher.data

import androidx.compose.ui.graphics.Color

data class Settings(

    val launcherVersion: String = "0.0.1",
    val checkForUpdates: Boolean = true,

    val packSettings: List<PackSettings> = listOf(
        PackSettings(1, Color(50, 255, 126, 200), "Performance", "Elevate your fps", listOf("FPS Boost", "Lightweight"), memoryMin = 512, memoryMax = 2048),
        PackSettings(2, Color(24, 220, 255, 200), "PvP", "Every ms counts", listOf("PvP", "FPS Boost"), memoryMin = 1024, memoryMax = 4096),
        PackSettings(3, Color(255, 204, 204, 200), "QOL", "Make your life easier with enhancements", listOf("Minimap", "Inventory Tweaks"), memoryMin = 1024, memoryMax = 4096),
    )
)

