package com.example.dbroom.daos

import androidx.room.Dao
import androidx.room.Query
import com.example.db.daos.ForecastDao
import com.example.models.WeatherForecast
import kotlinx.coroutines.flow.Flow

@Dao
abstract class RoomForecastDao: ForecastDao(), RoomEntityDao<WeatherForecast> {
    @Query("SELECT * from Forecast WHERE city LIKE :city")
    abstract override fun forecastWithCityName(city: String): Flow<List<WeatherForecast>>

    @Query("SELECT * from Forecast WHERE city LIKE :city AND timestamp >= :timestamp")
    abstract override fun forecastCityWithTimestamp(city: String, timestamp: Long): Flow<List<WeatherForecast>>

    @Query("DELETE from Forecast WHERE timestamp < :beforeTimestamp")
    abstract override fun deleteOutdatedData(beforeTimestamp: Long): Int
}