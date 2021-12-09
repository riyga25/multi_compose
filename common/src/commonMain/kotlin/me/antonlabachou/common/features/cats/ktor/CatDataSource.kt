package me.antonlabachou.common.features.cats.ktor

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonNull.serializer
import me.antonlabachou.common.features.cats.CatRemoteDataSource
import me.antonlabachou.common.features.cats.ktor.models.CatResponse

class CatDataSource(
    private val httpClient: HttpClient,
    val json: Json
): CatRemoteDataSource {

    override suspend fun fetchNews(): CatResponse {
        val httpRequest = httpClient.get<HttpStatement> {
            url {
                path("fact")
            }
        }

        return json.decodeFromString(
            CatResponse.serializer(),
            httpRequest.execute().readText()
        )
    }
}