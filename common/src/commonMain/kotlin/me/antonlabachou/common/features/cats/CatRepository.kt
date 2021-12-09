package me.antonlabachou.common.features.cats

class CatRepository(
    private val remoteDataSource: CatRemoteDataSource
) {

    suspend fun fetchNews() = remoteDataSource.fetchNews()
}