package com.fiz.starwarsinformer.common.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "films")
data class FilmEntity(
        val characters: List<String>,
        val created: String,
        val director: String,
        val edited: String,
        val episodeId: String,
        val openingCrawl: String,
        val planets: List<String>,
        val producer: String,
        val releaseDate: String,
        val species: List<String>,
        val starships: List<String>,
        @PrimaryKey
        val title: String,
        val url: String,
        val vehicles: List<String>,
)