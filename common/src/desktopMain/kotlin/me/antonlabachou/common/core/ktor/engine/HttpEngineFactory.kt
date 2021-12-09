package me.antonlabachou.common.core.ktor.engine

import io.ktor.client.engine.*
import io.ktor.client.engine.cio.*

actual class HttpEngineFactory {
    actual fun createEngine(): HttpClientEngineFactory<HttpClientEngineConfig> {
        return CIO
    }
}