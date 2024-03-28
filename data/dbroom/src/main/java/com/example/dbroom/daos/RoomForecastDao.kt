package com.example.dbroom.daos

import androidx.room.Dao
import androidx.room.Query
import com.example.db.daos.ForecastDao
import com.example.models.WeatherForecast

@Dao
abstract class RoomForecastDao: ForecastDao(), RoomEntityDao<WeatherForecast> {
    @Query("SELECT * from Forecast WHERE city = :city")
    abstract override suspend fun forecastWithCityName(city: String): List<WeatherForecast>
}