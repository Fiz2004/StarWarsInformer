package com.fiz.starwarsinformer.common.data.remote.dto.one

import com.fiz.starwarsinformer.common.data.local.entities.PeopleEntity
import com.google.gson.annotations.SerializedName

data class PeopleDto(
    @SerializedName("name") val name: String?,
    @SerializedName("height") val height: String?,
    @SerializedName("mass") val mass: String?,
    @SerializedName("hair_color") val hairColor: String?,
    @SerializedName("skin_color") val skinColor: String?,
    @SerializedName("eye_color") val eyeColor: String?,
    @SerializedName("birth_year") val birthYear: String?,
    @SerializedName("gender") val gender: String?,
    @SerializedName("homeworld") val homeWorld: String?,
    @SerializedName("films") val films: List<String?>?,
    @SerializedName("species") val species: List<String?>?,
    @SerializedName("vehicles") val vehicles: List<String?>?,
    @SerializedName("starships") val starships: List<String?>?,
    @SerializedName("created") val created: String?,
    @SerializedName("edited") val edited: String?,
    @SerializedName("url") val url: String?,
) {
    fun toPeopleEntity(): PeopleEntity {
        return PeopleEntity(
            name = name.orEmpty(),
            height = height.orEmpty(),
            mass = mass.orEmpty(),
            hairColor = hairColor.orEmpty(),
            skinColor = skinColor.orEmpty(),
            eyeColor = eyeColor.orEmpty(),
            birthYear = birthYear.orEmpty(),
            gender = gender.orEmpty(),
            homeWorld = homeWorld.orEmpty(),
            films = films?.mapNotNull { it } ?: listOf(),
            species = species?.mapNotNull { it } ?: listOf(),
            vehicles = vehicles?.mapNotNull { it } ?: listOf(),
            starships = starships?.mapNotNull { it } ?: listOf(),
            created = created.orEmpty(),
            edited = edited.orEmpty(),
            url = url.orEmpty(),
        )
    }
}