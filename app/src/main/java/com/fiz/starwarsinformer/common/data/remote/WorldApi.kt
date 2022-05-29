package com.fiz.starwarsinformer.common.data.remote

import com.fiz.starwarsinformer.common.data.remote.dto.one.*
import com.fiz.starwarsinformer.common.data.remote.dto.page.*
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WorldApi {

    @GET("people/")
    suspend fun getPagePeoples(
        @Query("page") page: Int
    ): PagePeoplesDto

    @GET("people/{name}/")
    suspend fun getPeopleByName(
        @Path("name") name: String
    ): PeopleDto

    @GET("planets/")
    suspend fun getPagePlanets(
        @Query("page") page: Int
    ): PagePlanetsDto

    @GET("planets/{id}/")
    suspend fun getPlanetById(
        @Path("id") id: String
    ): PlanetDto

    @GET("films/")
    suspend fun getPageFilms(
        @Query("page") page: Int
    ): PageFilmsDto

    @GET("films/{title}/")
    suspend fun getFilmByTitle(
        @Path("title") title: String
    ): FilmDto

    @GET("starships/")
    suspend fun getPageStarships(
        @Query("page") page: Int
    ): PageStarshipsDto

    @GET("starships/{name}/")
    suspend fun getStarshipByName(
        @Path("name") name: String
    ): StarshipDto

    @GET("vehicles/")
    suspend fun getPageVehicles(
        @Query("page") page: Int
    ): PageVehiclesDto

    @GET("vehicles/{name")
    suspend fun getVehicleByName(
        @Path("name") name: String
    ): VehicleDto

    @GET("species/")
    suspend fun getPageSpecies(
        @Query("page") page: Int
    ): PageSpeciesDto

    @GET("species/{name}/")
    suspend fun getSpeciesByName(
        @Path("name") name: String
    ): SpeciesDto

    companion object {
        const val BASE_URL = "https://swapi.dev/api/"
    }
}