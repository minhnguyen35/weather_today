package com.example.weatherforecast

import com.example.legacy.mappers.ApiWeatherToListForecast
import com.example.legacy.mappers.withRetry
import com.example.models.WeatherForecast
import com.github.prominence.openweathermap.api.OpenWeatherMapClient
import javax.inject.Inject

class DefaultForecastByCityDataSource @Inject constructor(
    private val weatherApi: OpenWeatherMapClient,
    private val mapper: ApiWeatherToListForecast
): ForecastByCityDataSource {

    override suspend fun getForecast(city: String) : List<WeatherForecast> {
        return withRetry {
            weatherApi.forecast5Day3HourStep()
                .byCityName(city)
                .retrieveAsync()
                .let {
                    try{
                        mapper.map(it.asJava().get())
                    }catch (e: Exception) {
                        println("minh nguyen exception $e")
                        emptyList()
                    }
                }

        }
    }
}