package com.example.db.daos

import com.example.models.WeatherForecast
import kotlinx.coroutines.flow.Flow

abstract class ForecastDao: EntityDao<WeatherForecast> {
    abstract fun forecastWithCityName(city: String): Flow<List<WeatherForecast>>
}