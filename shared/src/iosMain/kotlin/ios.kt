package com.jshvarts

import platform.UIKit.UIDevice

actual fun platformName(): String {
    return UIDevice.currentDevice.systemName() // takes advantage of the platform package
}
