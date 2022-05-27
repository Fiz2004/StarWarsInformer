package com.fiz.starwarsinformer.common.data.remote.dto.one

import com.fiz.starwarsinformer.common.data.local.entities.StarshipEntity
import com.google.gson.annotations.SerializedName

data class StarshipDto(
    @SerializedName("MGLT") val MGLT: String?,
    @SerializedName("cargo_capacity") val cargoCapacity: String?,
    @SerializedName("consumables") val consumables: String?,
    @SerializedName("cost_in_credits") val costInCredits: String?,
    @SerializedName("created") val created: String?,
    @SerializedName("crew") val crew: String?,
    @SerializedName("edited") val edited: String?,
    @SerializedName("hyperdrive_rating") val hyperDriveRating: String?,
    @SerializedName("length") val length: String?,
    @SerializedName("manufacturer") val manufacturer: String?,
    @SerializedName("max_atmosphering_speed") val maxAtmosphericSpeed: String?,
    @SerializedName("model") val model: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("passengers") val passengers: String?,
    @SerializedName("films") val films: List<String?>?,
    @SerializedName("pilots") val pilots: List<String?>?,
    @SerializedName("starship_class") val starshipClass: String?,
    @SerializedName("url") val url: String?,
) {
    fun toStarshipEntity(): StarshipEntity {
        return StarshipEntity(

            MGLT = MGLT.orEmpty(),
            cargoCapacity = cargoCapacity.orEmpty(),
            consumables = consumables.orEmpty(),
            costInCredits = costInCredits.orEmpty(),
            created = created.orEmpty(),
            crew = crew.orEmpty(),
            edited = edited.orEmpty(),
            hyperDriveRating = hyperDriveRating.orEmpty(),
            length = length.orEmpty(),
            manufacturer = manufacturer.orEmpty(),
            maxAtmosphericSpeed = maxAtmosphericSpeed.orEmpty(),
            model = model.orEmpty(),
            name = name.orEmpty(),
            passengers = passengers.orEmpty(),
            films = films?.mapNotNull { it } ?: listOf(),
            pilots = pilots?.mapNotNull { it } ?: listOf(),
            starshipClass = starshipClass.orEmpty(),
            url = url.orEmpty(),
        )
    }
}