package com.fiz.starwarsinformer.features.films.data.repositories

import com.fiz.starwarsinformer.R
import com.fiz.starwarsinformer.common.data.local.dao.FilmDao
import com.fiz.starwarsinformer.common.data.local.entities.FilmEntity
import com.fiz.starwarsinformer.common.data.remote.WorldApi
import com.fiz.starwarsinformer.common.utils.Resource
import com.fiz.starwarsinformer.features.films.domain.models.Film
import com.fiz.starwarsinformer.features.films.domain.repositories.FilmRepository
import javax.inject.Inject

class FilmRepositoryImpl @Inject constructor(
        private val remoteDataSource: WorldApi,
        private val localDataSource: FilmDao
) : FilmRepository {

    override suspend fun getFilms(fetchFromRemote: Boolean): Resource<List<Film>> {
        val localData = localDataSource.getFilms()
        val result = Resource.Success(
            data = localData.map { it.toFilm() }
        )

        val shouldJustLoadFromCache = localData.isNotEmpty() && !fetchFromRemote
        if (shouldJustLoadFromCache) {
            return result
        }

        var page = 1
        val remoteResults: MutableList<FilmEntity>? = mutableListOf()

        do {
            val remoteData = try {
                remoteDataSource.getPageFilms(page)
            } catch (e: Exception) {
                e.printStackTrace()
                return Resource.Error(R.string.network_error)
            }

            if (remoteResults != null) {
                remoteResults += remoteData.results?.mapNotNull { it?.toFilmEntity() }
                    ?: listOf()
            }

            page += 1

        } while (remoteData.next != null)

        remoteResults.let { data ->
            data?.let {
                localDataSource.clearFilms()
                localDataSource.insertFilms(
                    it
                )
            }
            return Resource.Success(
                data = localDataSource
                    .getFilms()
                    .map { it.toFilm() }
            )
        }
    }

    override suspend fun getFilm(title: String): Resource<Film> {
        return try {
            val localData = localDataSource.getFilm(title)
            Resource.Success(
                data = localData.toFilm()
            )
        } catch (e: Exception) {
            Resource.Error(message = R.string.network_error)
        }
    }
}