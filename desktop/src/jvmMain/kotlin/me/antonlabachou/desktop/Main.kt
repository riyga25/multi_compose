package me.antonlabachou.desktop

import me.antonlabachou.common.App
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import me.antonlabachou.common.di.EngineSDK

fun main() = application {
    EngineSDK.init()

    Window(
        onCloseRequest = ::exitApplication,
        title = "Cat Facts",
        icon = painterResource("icons/mad_logo.png")
    ) {
        MaterialTheme {
            App()
        }
    }
}