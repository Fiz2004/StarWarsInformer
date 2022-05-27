package com.fiz.starwarsinformer.common.data.remote.dto.one

import com.fiz.starwarsinformer.common.data.local.entities.FilmEntity
import com.google.gson.annotations.SerializedName

data class FilmDto(
        @SerializedName("characters") val characters: List<String?>?,
        @SerializedName("created") val created: String?,
        @SerializedName("director") val director: String?,
        @SerializedName("edited") val edited: String?,
        @SerializedName("episode_id") val episodeId: String?,
        @SerializedName("opening_crawl") val openingCrawl: String?,
        @SerializedName("planets") val planets: List<String?>?,
        @SerializedName("producer") val producer: String?,
        @SerializedName("release_date") val releaseDate: String?,
        @SerializedName("species") val species: List<String?>?,
        @SerializedName("starships") val starships: List<String?>?,
        @SerializedName("title") val title: String?,
        @SerializedName("url") val url: String?,
        @SerializedName("vehicles") val vehicles: List<String?>?,
) {
        fun toFilmEntity(): FilmEntity {
                return FilmEntity(
                        characters = characters?.mapNotNull { it } ?: listOf(),
                        created = created.orEmpty(),
                        director = director.orEmpty(),
                        edited = edited.orEmpty(),
                        episodeId = episodeId.orEmpty(),
                        openingCrawl = openingCrawl.orEmpty(),
                        planets = planets?.mapNotNull { it } ?: listOf(),
                        producer = producer.orEmpty(),
                        releaseDate = releaseDate.orEmpty(),
                        species = species?.mapNotNull { it } ?: listOf(),
                        starships = starships?.mapNotNull { it } ?: listOf(),
                        title = title.orEmpty(),
                        url = url.orEmpty(),
                        vehicles = vehicles?.mapNotNull { it } ?: listOf(),
                )
        }
}