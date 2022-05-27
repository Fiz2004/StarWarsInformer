package com.fiz.starwarsinformer.common.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fiz.starwarsinformer.features.peoples.domain.models.People

@Entity(tableName = "peoples")
data class PeopleEntity(
        @PrimaryKey
        val name: String,
        val height: String,
        val mass: String,
        val hairColor: String,
        val skinColor: String,
        val eyeColor: String,
        val birthYear: String,
        val gender: String,
        val homeWorld: String,
        val films: List<String>,
        val species: List<String>,
        val vehicles: List<String>,
        val starships: List<String>,
        val created: String,
        val edited: String,
        val url: String,
) {

    fun toPeople(): People {
        return People(
            name = name,
            height = height,
            mass = mass,
            hairColor = hairColor,
            skinColor = skinColor,
            eyeColor = eyeColor,
            birthYear = birthYear,
            gender = gender,
            homeWorld = homeWorld,
            films = films,
            species = species,
            vehicles = vehicles,
            starships = starships,
            created = created,
            edited = edited,
            url = url,
        )
    }

    companion object {
        const val NAME_FOR_DAO = "PEOPLE"
    }
}