package com.fiz.starwarsinformer.di

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
}