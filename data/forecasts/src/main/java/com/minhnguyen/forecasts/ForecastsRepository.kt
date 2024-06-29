package com.minhnguyen.forecasts

import com.example.models.WeatherForecast
import com.minhnguyen.network.models.NetworkWeatherForecast
import kotlinx.coroutines.flow.Flow

interface ForecastsRepository {
    fun getForecastsByCity(city: String) : Flow<List<WeatherForecast>>
    suspend fun syncData(city: String): Boolean
    suspend fun deleteOutdatedData(beforeTimestamp: Long): Int
}