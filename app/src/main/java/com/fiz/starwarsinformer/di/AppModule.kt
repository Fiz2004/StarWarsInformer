package com.fiz.starwarsinformer.di

import android.app.Application
import androidx.room.Room
import com.fiz.starwarsinformer.common.data.local.dao.*
import com.fiz.starwarsinformer.common.data.local.database.WorldDatabase
import com.fiz.starwarsinformer.common.data.remote.WorldApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

private const val NAME_DATABASE = "worldDB.db"

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideWorldApi(): WorldApi {
        return Retrofit.Builder()
            .baseUrl(WorldApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WorldApi::class.java)
    }

    @Provides
    @Singleton
    fun provideWorldDatabase(app: Application): WorldDatabase {
        return Room.databaseBuilder(
                app,
                WorldDatabase::class.java,
                NAME_DATABASE
        ).build()
    }

    @Provides
    @Singleton
    fun providePeopleDao(worldDatabase: WorldDatabase): PeopleDao {
        return worldDatabase.peopleDao
    }

    @Provides
    @Singleton
    fun providePlanetDao(worldDatabase: WorldDatabase): PlanetDao {
        return worldDatabase.planetDao
    }

    @Provides
    @Singleton
    fun provideSpeciesDao(worldDatabase: WorldDatabase): SpeciesDao {
        return worldDatabase.speciesDao
    }

    @Provides
    @Singleton
    fun provideStarshipDao(worldDatabase: WorldDatabase): StarshipDao {
        return worldDatabase.starshipDao
    }

    @Provides
    @Singleton
    fun provideVehicleDao(worldDatabase: WorldDatabase): VehicleDao {
        return worldDatabase.vehicleDao
    }

    @Provides
    @Singleton
    fun provideFilmDao(worldDatabase: WorldDatabase): FilmDao {
        return worldDatabase.filmDao
    }

}