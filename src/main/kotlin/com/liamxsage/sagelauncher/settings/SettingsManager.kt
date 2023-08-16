package com.liamxsage.sagelauncher.settings

import com.google.gson.Gson
import com.liamxsage.sagelauncher.data.Settings
import net.harawata.appdirs.AppDirsFactory
import java.io.FileReader
import java.io.FileWriter
import java.nio.file.Paths

/**
 * Singleton class that loads and saves settings into a JSON file in the user's appdata folder.
 */
object SettingsManager {
    private val gson = Gson()
    private val sageDirectory = Paths.get(AppDirsFactory.getInstance().getUserDataDir(".sage", null, "liamxsage"))
    private val settingsFilePath = Paths.get(sageDirectory.toString(), "settings.json").toFile()

    var settings: Settings? = null
        private set

    fun loadSettings() {
        if (sageDirectory.toFile().mkdirs()) {
            println("Created .sage directory")
        }

        if (!settingsFilePath.exists()) {
            println("Settings file does not exist, creating...")
            settingsFilePath.createNewFile()
            settings = Settings()
            saveSettings()
        }

        val reader = FileReader(settingsFilePath)
        settings = gson.fromJson(reader, Settings::class.java)
        reader.close()
    }

    fun saveSettings() {
        if (settings != null) {
            val writer = FileWriter(settingsFilePath)
            gson.toJson(settings, writer)
            writer.close()
        }
    }
}