package com.fiz.starwarsinformer.common.data.remote.dto.one

import com.fiz.starwarsinformer.common.data.local.entities.PlanetEntity
import com.google.gson.annotations.SerializedName

data class PlanetDto(
    @SerializedName("climate") val climate: String?,
    @SerializedName("created") val created: String?,
    @SerializedName("diameter") val diameter: String?,
    @SerializedName("edited") val edited: String?,
    @SerializedName("films") val films: List<String?>?,
    @SerializedName("gravity") val gravity: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("orbital_period") val orbitalPeriod: String?,
    @SerializedName("population") val population: String?,
    @SerializedName("residents") val residents: List<String?>?,
    @SerializedName("rotation_period") val rotationPeriod: String?,
    @SerializedName("surface_water") val surfaceWater: String?,
    @SerializedName("terrain") val terrain: String?,
    @SerializedName("url") val url: String?,
) {
    fun toPlanetEntity(): PlanetEntity {
        return PlanetEntity(
            climate = climate.orEmpty(),
            created = created.orEmpty(),
            diameter = diameter.orEmpty(),
            edited = edited.orEmpty(),
            films = films?.mapNotNull { it } ?: listOf(),
            gravity = gravity.orEmpty(),
            name = name.orEmpty(),
            orbitalPeriod = orbitalPeriod.orEmpty(),
            population = population.orEmpty(),
            residents = residents?.mapNotNull { it } ?: listOf(),
            rotationPeriod = rotationPeriod.orEmpty(),
            surfaceWater = surfaceWater.orEmpty(),
            terrain = terrain.orEmpty(),
            url = url.orEmpty(),
        )
    }
}