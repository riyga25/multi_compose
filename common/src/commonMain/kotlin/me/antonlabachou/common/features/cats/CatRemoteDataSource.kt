package me.antonlabachou.common.features.cats

import me.antonlabachou.common.features.cats.ktor.models.CatResponse

interface CatRemoteDataSource {
    suspend fun fetchNews(): CatResponse
}