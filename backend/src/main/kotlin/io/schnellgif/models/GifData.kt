package io.schnellgif.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.JsonTransformingSerializer
import kotlinx.serialization.json.jsonPrimitive

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
    @Serializable(with = NormaliseImageUrlInterceptor::class)
    val imgUrl: String,
)

object NormaliseImageUrlInterceptor : JsonTransformingSerializer<String>(String.serializer()) {
    override fun transformDeserialize(element: JsonElement): JsonElement {
        return JsonPrimitive(element.jsonPrimitive.content.substringAfter("//"))
    }
}