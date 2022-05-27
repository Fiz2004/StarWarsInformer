package com.fiz.starwarsinformer.common.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fiz.starwarsinformer.features.films.domain.models.Film

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
) {

        fun toFilm(): Film {
                return Film(
                        characters = characters,
                        created = created,
                        director = director,
                        edited = edited,
                        episodeId = episodeId,
                        openingCrawl = openingCrawl,
                        planets = planets,
                        producer = producer,
                        releaseDate = releaseDate,
                        species = species,
                        starships = starships,
                        title = title,
                        url = url,
                        vehicles = vehicles
                )
        }

        companion object {
                const val NAME_FOR_DAO = "FILM"
        }
}