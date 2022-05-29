package com.fiz.starwarsinformer.features.starships.domain.models

data class Starship(
        val MGLT: String,
        val cargoCapacity: String,
        val consumables: String,
        val costOnCredits: String,
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
)