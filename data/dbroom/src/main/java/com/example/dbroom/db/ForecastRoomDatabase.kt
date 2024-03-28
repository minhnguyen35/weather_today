package com.example.dbroom.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.db.db.ForecastDatabase
import com.example.dbroom.daos.RoomForecastDao
import com.example.models.WeatherForecast

@Database(
    entities = [
        WeatherForecast::class
    ],
    version = 1
)
abstract class ForecastRoomDatabase : ForecastDatabase, RoomDatabase(){
    abstract override fun forecastByCityDao(): RoomForecastDao
}