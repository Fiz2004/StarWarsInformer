package com.fiz.starwarsinformer.common.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

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
)