package com.fiz.starwarsinformer.common.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.fiz.starwarsinformer.common.data.local.dao.*
import com.fiz.starwarsinformer.common.data.local.entities.*

@Database(
        entities = [
            FilmEntity::class,
            PeopleEntity::class,
            PlanetEntity::class,
            SpeciesEntity::class,
            StarshipEntity::class,
            VehicleEntity::class
        ],
        version = 1
)
@TypeConverters(StringListConverter::class)
abstract class WorldDatabase : RoomDatabase() {
    abstract val filmDao: FilmDao
    abstract val peopleDao: PeopleDao
    abstract val planetDao: PlanetDao
    abstract val speciesDao: SpeciesDao
    abstract val starshipDao: StarshipDao
    abstract val vehicleDao: VehicleDao
}