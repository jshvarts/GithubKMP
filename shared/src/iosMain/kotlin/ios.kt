package com.jshvarts

import platform.UIKit.UIDevice

actual fun platformName(): String {
    return "${UIDevice.currentDevice.systemName} ${UIDevice.currentDevice.systemVersion}" // takes advantage of the platform package
}
