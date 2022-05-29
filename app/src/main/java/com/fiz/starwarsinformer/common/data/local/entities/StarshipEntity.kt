package com.fiz.starwarsinformer.common.data.local.entities

import androidx.room.Entity

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
    companion object {
        const val NAME_FOR_DAO = "STARSHIP"
    }
}