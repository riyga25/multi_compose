package me.antonlabachou.common.features.cats

import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton
import me.antonlabachou.common.di.EngineSDK
import me.antonlabachou.common.features.cats.ktor.CatDataSource
import kotlin.native.concurrent.ThreadLocal

internal val hubbleModule = DI.Module(
    name = "HubbleModule",
    init = {
        bind<CatRemoteDataSource>() with singleton {
            CatDataSource(
                httpClient = instance(),
                json = instance()
            )
        }

        bind<CatRepository>() with singleton {
            CatRepository(
                remoteDataSource = instance()
            )
        }
    }
)

@ThreadLocal
object HubbleModule {

    val hubbleRepository: CatRepository
        get() = EngineSDK.di.instance()
}

val EngineSDK.hubble: HubbleModule
    get() = HubbleModule