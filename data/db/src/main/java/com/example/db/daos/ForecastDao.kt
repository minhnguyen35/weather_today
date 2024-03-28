package com.example.db.daos

import com.example.models.WeatherForecast

abstract class ForecastDao: EntityDao<WeatherForecast> {
    abstract suspend fun forecastWithCityName(city: String): List<WeatherForecast>
}