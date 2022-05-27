package com.fiz.starwarsinformer.common.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fiz.starwarsinformer.features.species.domain.models.Species

@Entity(tableName = "species")
data class SpeciesEntity(
        val averageHeight: String,
        val averageLifespan: String,
        val classification: String,
        val created: String,
        val designation: String,
        val edited: String,
        val eyeColors: String,
        val hairColors: String,
        val homeWorld: String,
        val language: String,
        @PrimaryKey
        val name: String,
        val people: List<String>,
        val films: List<String>,
        val skinColors: String,
        val url: String,
) {

    fun toSpecies(): Species {
        return Species(
            averageHeight = averageHeight,
            averageLifespan = averageLifespan,
            classification = classification,
            created = created,
            designation = designation,
            edited = edited,
            eyeColors = eyeColors,
            hairColors = hairColors,
            homeWorld = homeWorld,
            language = language,
            name = name,
            people = people,
            films = films,
            skinColors = skinColors,
            url = url,
        )
    }

    companion object {
        const val NAME_FOR_DAO = "SPECIES"
    }
}