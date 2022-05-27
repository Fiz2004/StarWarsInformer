package com.fiz.starwarsinformer.common.data.remote.dto.one

import com.fiz.starwarsinformer.common.data.local.entities.SpeciesEntity
import com.google.gson.annotations.SerializedName

data class SpeciesDto(
    @SerializedName("average_height") val averageHeight: String?,
    @SerializedName("average_lifespan") val averageLifespan: String?,
    @SerializedName("classification") val classification: String?,
    @SerializedName("created") val created: String?,
    @SerializedName("designation") val designation: String?,
    @SerializedName("edited") val edited: String?,
    @SerializedName("eye_colors") val eyeColors: String?,
    @SerializedName("hair_colors") val hairColors: String?,
    @SerializedName("homeworld") val homeWorld: String?,
    @SerializedName("language") val language: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("people") val people: List<String?>?,
    @SerializedName("films") val films: List<String?>?,
    @SerializedName("skin_colors") val skinColors: String?,
    @SerializedName("url") val url: String?,
) {
    fun toSpeciesEntity(): SpeciesEntity {
        return SpeciesEntity(
            averageHeight = averageHeight.orEmpty(),
            averageLifespan = averageLifespan.orEmpty(),
            classification = classification.orEmpty(),
            created = created.orEmpty(),
            designation = designation.orEmpty(),
            edited = edited.orEmpty(),
            eyeColors = eyeColors.orEmpty(),
            hairColors = hairColors.orEmpty(),
            homeWorld = homeWorld.orEmpty(),
            language = language.orEmpty(),
            name = name.orEmpty(),
            people = people?.mapNotNull { it } ?: listOf(),
            films = films?.mapNotNull { it } ?: listOf(),
            skinColors = skinColors.orEmpty(),
            url = url.orEmpty(),
        )
    }
}