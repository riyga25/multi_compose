package me.antonlabachou.common.core

import org.kodein.di.DI
import me.antonlabachou.common.core.ktor.ktorModule
import me.antonlabachou.common.core.serialization.serializationModule

val coreModule = DI.Module {
    importAll(
        ktorModule,
        serializationModule
    )
}