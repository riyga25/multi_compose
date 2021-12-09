package me.antonlabachou.common.features

import org.kodein.di.DI
import me.antonlabachou.common.features.cats.hubbleModule

val featureModule = DI.Module {
    importAll(
        hubbleModule
    )
}