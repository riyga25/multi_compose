package me.antonlabachou.desktop

import me.antonlabachou.common.App
import androidx.compose.desktop.DesktopMaterialTheme
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import me.antonlabachou.common.di.EngineSDK

fun main() = application {
    EngineSDK.init()

    Window(onCloseRequest = ::exitApplication) {
        DesktopMaterialTheme {
            App()
        }
    }
}