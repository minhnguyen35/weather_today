package com.example.db.daos

import com.example.models.WeatherForecast
import kotlinx.coroutines.flow.Flow

abstract class ForecastDao: EntityDao<WeatherForecast> {
    abstract fun forecastWithCityName(city: String): Flow<List<WeatherForecast>>

    abstract fun forecastCityWithTimestamp(city: String, timestamp: Long): Flow<List<WeatherForecast>>
}