package com.liamxsage.sagelauncher.manager

import com.liamxsage.sagelauncher.data.PackSettings

object ModManager {

    /**
     * Launches the modpack specified by the given [PackSettings].
     * Before launching, it will check for the integrity of the modpack.
     * If the modpack is not installed, it will install the modpack.
     * If the modpack is outdated, it will update the modpack.
     * If the modpack is missing mods, it will install the missing mods.
     * If the modpack has corrupted mods, it will reinstall the corrupted mods.
     *
     * To launch the modpack, we will use the [PackSettings.javaArgs] and [PackSettings.memoryMin] and [PackSettings.memoryMax] settings.
     * With these settings, we will launch the modpack using the [PackSettings.javaVersion] version of Java.
     *
     * @param pack The settings of the modpack to be launched.
     */
    fun launchModpack(pack: PackSettings) {
        println("Launching modpack ${pack.title}")
        testPackIntegrity(pack)
    }

    /**
     * Installs the specified modpack.
     * This includes downloading the modpack's mods, downloading the modpack's mod list, and installing the mods.
     * If a remote modpack is specified, it will download the remote modpack's mod list and install the mods from the remote modpack.
     * Otherwise, it will install the mods from the modpack's mod list.
     *
     * @param pack The settings for the modpack to install.
     */
    fun installModpack(pack: PackSettings) {
        println("Installing modpack ${pack.title}")
    }

    /**
     * Checks for updates for the specified modpack.
     * If a remote modpack is specified, it will check for updates on the remote modpack.
     * Otherwise, it will check for updates on the modpack's mod list.
     *
     * @param pack The modpack settings to check for updates on.
     */
    fun checkForUpdates(pack: PackSettings) {
        println("Checking for updates for modpack ${pack.title}")
    }

    /**
     * Tests the integrity of a modpack.
     * This includes checking for missing mods, corrupted mods, and outdated mods.
     * To do so, it will compare the modpack's mod checksums to the checksums of the mods in the user's mods folder.
     *
     * @param pack The pack settings to be tested.
     */
    fun testPackIntegrity(pack: PackSettings) {
        println("Testing modpack ${pack.title}")
    }

    fun updateModpack(pack: PackSettings) {
        println("Updating modpack ${pack.title}")
    }

}