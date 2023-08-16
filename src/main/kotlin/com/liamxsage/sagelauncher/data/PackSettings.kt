package com.liamxsage.sagelauncher.data

import androidx.compose.ui.graphics.Color

/**
 * Represents settings for a software package.
 *
 * @property id The unique identifier of the package.
 * @property color The color associated with the package.
 * @property title The title or name of the package.
 * @property description The description of the package.
 * @property features The list of features provided by the package.
 * @property selectedVersion The selected version of the package. Default is "latest".
 * @property memoryMin The minimum memory required for the package in megabytes. Default is 1024.
 * @property memoryMax The maximum memory allowed for the package in megabytes. Default is 4096.
 * @property javaVersion The required Java version for the package. Default is "default".
 * @property javaArgs The Java arguments to be used for running the package. Default is "-XX:+UnlockExperimentalVMOptions -XX:+UseG1GC -XX:G1NewSizePercent=20 -XX:G1ReservePercent=20 -XX:MaxGCPauseMillis=50 -XX:G1HeapRegionSize=32".
 */
data class PackSettings(
    val id: Int,
    val color: Color,
    val title: String,
    val description: String,
    val features: List<String>,
    val selectedVersion: String = "latest",
    val memoryMin: Long = 1024,
    val memoryMax: Long = 4096,
    val javaVersion: String = "default",
    val javaArgs: String = "-XX:+UnlockExperimentalVMOptions -XX:+UseG1GC -XX:G1NewSizePercent=20 -XX:G1ReservePercent=20 -XX:MaxGCPauseMillis=50 -XX:G1HeapRegionSize=32",
    val modList: List<String> = listOf(),
    val versionOverrides: List<VersionOverride> = listOf(),
    val modListRemoteModpack: String? = null,
)

data class VersionOverride(
    val modId: String,
    val gameVersion: String,
    val modVersion: String
)
