package com.jshvarts

import com.russhwolf.settings.PlatformSettings

actual class UserSettings {
    fun userSettings() = PlatformSettings.Factory().create()
}
