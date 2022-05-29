package com.fiz.starwarsinformer.features.vehicles.domain.models

data class Vehicle(
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
)