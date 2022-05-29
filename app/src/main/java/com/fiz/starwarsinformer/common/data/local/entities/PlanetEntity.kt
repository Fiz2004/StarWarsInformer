package com.fiz.starwarsinformer.common.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "planets")
data class PlanetEntity(
        val climate: String,
        val created: String,
        val diameter: String,
        val edited: String,
        val films: List<String>,
        val gravity: String,
        @PrimaryKey
        val name: String,
        val orbitalPeriod: String,
        val population: String,
        val residents: List<String>,
        val rotationPeriod: String,
        val surfaceWater: String,
        val terrain: String,
        val url: String,
) {
        companion object {
                const val NAME_FOR_DAO = "PLANET"
        }
}