package com.fiz.starwarsinformer.common.data.local.entities

import androidx.room.Entity
import com.fiz.starwarsinformer.features.starships.domain.models.Starship

@Entity(tableName = "starships", primaryKeys = ["name", "model"])
data class StarshipEntity(
        val MGLT: String,
        val cargoCapacity: String,
        val consumables: String,
        val costInCredits: String,
        val created: String,
        val crew: String,
        val edited: String,
        val hyperDriveRating: String,
        val length: String,
        val manufacturer: String,
        val maxAtmosphericSpeed: String,
        val model: String,
        val name: String,
        val passengers: String,
        val films: List<String>,
        val pilots: List<String>,
        val starshipClass: String,
        val url: String,
) {

    fun toStarship(): Starship {
        return Starship(
            MGLT = MGLT,
            cargoCapacity = cargoCapacity,
            consumables = consumables,
            costOnCredits = costInCredits,
            created = created,
            crew = crew,
            edited = edited,
            hyperDriveRating = hyperDriveRating,
            length = length,
            manufacturer = manufacturer,
            maxAtmosphericSpeed = maxAtmosphericSpeed,
            model = model,
            name = name,
            passengers = passengers,
            films = films,
            pilots = pilots,
            starshipClass = starshipClass,
            url = url,
        )
    }

    companion object {
        const val NAME_FOR_DAO = "STARSHIP"
    }
}