package io.schnellgif.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GifDataList(
    val data: List<GifData>
)

@Serializable
data class GifData(
    @SerialName("short_name")
    val shortName: String,
    @SerialName("short_intro")
    val shortIntro: String,
    @SerialName("img_url")
    val imgUrl: String,
)