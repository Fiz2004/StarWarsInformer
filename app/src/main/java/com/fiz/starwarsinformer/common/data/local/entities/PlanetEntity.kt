package com.fiz.starwarsinformer.common.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fiz.starwarsinformer.features.planets.domain.models.Planet

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

    fun toPlanet(): Planet {
        return Planet(
            climate = climate,
            created = created,
            diameter = diameter,
            edited = edited,
            films = films,
            gravity = gravity,
            name = name,
            orbitalPeriod = orbitalPeriod,
            population = population,
            residents = residents,
            rotationPeriod = rotationPeriod,
            surfaceWater = surfaceWater,
            terrain = terrain,
            url = url,
        )
    }

    companion object {
        const val NAME_FOR_DAO = "PLANET"
    }
}