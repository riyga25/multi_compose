package me.antonlabachou.common.features.cats.ktor.models

import kotlinx.serialization.Serializable

@Serializable
data class CatResponse(
    val fact: String,
)