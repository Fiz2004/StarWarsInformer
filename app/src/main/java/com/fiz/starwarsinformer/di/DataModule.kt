package com.fiz.starwarsinformer.di

import com.fiz.starwarsinformer.features.films.data.repositories.FilmRepositoryImpl
import com.fiz.starwarsinformer.features.films.domain.repositories.FilmRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun bindFilmRepository(filmRepository: FilmRepositoryImpl): FilmRepository

}