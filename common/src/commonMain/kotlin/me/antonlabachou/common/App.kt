package me.antonlabachou.common

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.material.Button
import androidx.compose.runtime.*
import me.antonlabachou.common.di.EngineSDK
import me.antonlabachou.common.features.cats.hubble

@Composable
fun App() {
    var text by remember { mutableStateOf("Hello, World!") }
    var news by remember { mutableStateOf("null") }

    Column {
        Button(onClick = {
            text = "Hello, ${getPlatformName()}"
        }) {
            Text(text)
        }
        Text(news)

        LaunchedEffect(Unit) {
            val result = EngineSDK.hubble.hubbleRepository.fetchNews()
            news = result.fact
        }
    }
}
