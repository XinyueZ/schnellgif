package io.schnellgif.repositories

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.schnellgif.models.GifData
import io.schnellgif.models.GifDataList
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

interface GifRepository {
    suspend fun query(num: Int = 5, page: Int = 0): GifDataList
}

class GifRepositoryImpl(private val client: HttpClient) : GifRepository {

    override suspend fun query(num: Int, page: Int) = coroutineScope {
        val listAsync =
            async { client.get<GifDataList>("https://interface.sina.cn/tech/gif/album.d.json?format=json&num=$num&page=$page") }
        return@coroutineScope listAsync.await()
    }
}