package com.fiz.starwarsinformer.common.data.remote.dto.one

import com.fiz.starwarsinformer.common.data.local.entities.VehicleEntity
import com.google.gson.annotations.SerializedName

data class VehicleDto(
    @SerializedName("cargo_capacity") val cargoCapacity: String?,
    @SerializedName("consumables") val consumables: String?,
    @SerializedName("cost_in_credits") val costInCredits: String?,
    @SerializedName("created") val created: String?,
    @SerializedName("crew") val crew: String?,
    @SerializedName("edited") val edited: String?,
    @SerializedName("length") val length: String?,
    @SerializedName("manufacturer") val manufacturer: String?,
    @SerializedName("max_atmosphering_speed") val maxAtmosphericSpeed: String?,
    @SerializedName("model") val model: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("passengers") val passengers: String?,
    @SerializedName("pilots") val pilots: List<String?>?,
    @SerializedName("films") val films: List<String?>?,
    @SerializedName("url") val url: String?,
    @SerializedName("vehicle_class") val vehicleClass: String?,
) {
    fun toVehicleEntity(): VehicleEntity {
        return VehicleEntity(

            cargoCapacity = cargoCapacity.orEmpty(),
            consumables = consumables.orEmpty(),
            costInCredits = costInCredits.orEmpty(),
            created = created.orEmpty(),
            crew = crew.orEmpty(),
            edited = edited.orEmpty(),
            length = length.orEmpty(),
            manufacturer = manufacturer.orEmpty(),
            maxAtmosphericSpeed = maxAtmosphericSpeed.orEmpty(),
            model = model.orEmpty(),
            name = name.orEmpty(),
            passengers = passengers.orEmpty(),
            pilots = pilots?.mapNotNull { it } ?: listOf(),
            films = films?.mapNotNull { it } ?: listOf(),
            url = url.orEmpty(),
            vehicleClass = vehicleClass.orEmpty(),
        )
    }
}