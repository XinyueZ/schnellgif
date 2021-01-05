package io.schnellgif.viewmodels.entities

import io.schnellgif.models.GifData
import kotlinx.serialization.Serializable

@Serializable
data class GifDataEntity(
    val name: String,
    val description: String,
    val location: String,
) {
    companion object {
        infix fun from(data: GifData) = GifDataEntity(
            data.shortName,
            data.shortIntro,
            data.imgUrl.trimStart('/').trimStart('/'),
        )
    }
}