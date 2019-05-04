package com.jshvarts

import android.content.Context
import com.russhwolf.settings.PlatformSettings

actual class UserSettings {
    fun userSettings(context: Context) = PlatformSettings.Factory(context).create()
}
