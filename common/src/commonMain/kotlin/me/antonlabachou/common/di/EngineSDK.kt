package me.antonlabachou.common.di

import org.kodein.di.*
import me.antonlabachou.common.core.coreModule
import me.antonlabachou.common.features.featureModule

object EngineSDK {

    internal val di: DirectDI
        get() = requireNotNull(_di)
    private var _di: DirectDI? = null

    fun init() {
        if (_di != null) {
            _di = null
        }

        val direct = DI {
            importAll(
                featureModule,
                coreModule
            )
        }.direct

        _di = direct
    }
}