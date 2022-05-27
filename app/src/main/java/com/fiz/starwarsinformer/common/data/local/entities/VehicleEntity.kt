package com.fiz.starwarsinformer.common.data.local.entities

import androidx.room.Entity
import com.fiz.starwarsinformer.features.vehicles.domain.models.Vehicle

@Entity(tableName = "vehicles", primaryKeys = ["name", "model"])
data class VehicleEntity(
        val cargoCapacity: String,
        val consumables: String,
        val costInCredits: String,
        val created: String,
        val crew: String,
        val edited: String,
        val length: String,
        val manufacturer: String,
        val maxAtmosphericSpeed: String,
        val model: String,
        val name: String,
        val passengers: String,
        val pilots: List<String>,
        val films: List<String>,
        val url: String,
        val vehicleClass: String,
) {

    fun toVehicle(): Vehicle {
        return Vehicle(
            cargoCapacity = cargoCapacity,
            consumables = consumables,
            costInCredits = costInCredits,
            created = created,
            crew = crew,
            edited = edited,
            length = length,
            manufacturer = manufacturer,
            maxAtmosphericSpeed = maxAtmosphericSpeed,
            model = model,
            name = name,
            passengers = passengers,
            pilots = pilots,
            films = films,
            url = url,
            vehicleClass = vehicleClass,
        )
    }

    companion object {
        const val NAME_FOR_DAO = "VEHICLE"
    }
}