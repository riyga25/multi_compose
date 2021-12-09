package me.antonlabachou.android

import me.antonlabachou.common.App
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import me.antonlabachou.common.di.EngineSDK

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        EngineSDK.init()

        setContent {
            MaterialTheme {
                App()
            }
        }
    }
}