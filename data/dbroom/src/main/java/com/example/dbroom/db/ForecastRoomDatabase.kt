package com.example.dbroom.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.db.daos.SyncDataDao
import com.example.db.db.ForecastDatabase
import com.example.dbroom.daos.RoomForecastDao
import com.example.dbroom.daos.RoomSyncDataDao
import com.example.models.SyncInformation
import com.example.models.WeatherForecast

@Database(
    entities = [
        WeatherForecast::class,
        SyncInformation::class
    ],
    version = 3,
    exportSchema = false
)
abstract class ForecastRoomDatabase : ForecastDatabase, RoomDatabase(){
    abstract override fun forecastByCityDao(): RoomForecastDao
    abstract override fun syncDataDao(): RoomSyncDataDao
}