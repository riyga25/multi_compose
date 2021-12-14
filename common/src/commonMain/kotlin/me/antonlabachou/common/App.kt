package me.antonlabachou.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.material.Button
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import me.antonlabachou.common.di.EngineSDK
import me.antonlabachou.common.features.cats.hubble

@Composable
fun App() {
    var news by remember { mutableStateOf("null") }
    val scope = rememberCoroutineScope()

    fun getResult() {
        scope.launch {
            val result = EngineSDK.hubble.hubbleRepository.fetchNews()
            news = result.fact
        }
    }

    Column {
        Text(news)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = ::getResult) {
            Text("Refresh")
        }
    }

    LaunchedEffect(Unit) {
        getResult()
    }
}
