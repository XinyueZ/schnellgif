package io.schnellgif.viewmodels

import io.schnellgif.repositories.GifRepository
import io.schnellgif.viewmodels.entities.GifDataEntity

class GifListViewModel(private val repository: GifRepository) {
    suspend fun getGifList(num: Int = 5, page: Int = 0): List<GifDataEntity> {
        return repository.query(num, page).data.map { GifDataEntity from it }
    }
}