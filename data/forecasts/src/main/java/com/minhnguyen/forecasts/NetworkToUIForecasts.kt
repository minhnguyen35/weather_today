package com.minhnguyen.forecasts

import com.example.legacy.mappers.Mapper
import com.example.models.WeatherForecast
import com.minhnguyen.network.models.Network3HoursForecast
import javax.inject.Inject

class NetworkToUIForecasts @Inject constructor(): Mapper<Network3HoursForecast, List<WeatherForecast>> {
    override suspend fun map(from: Network3HoursForecast): List<WeatherForecast> {
        val listWeatherForecast = mutableListOf<WeatherForecast>()
        from.let { threeH ->
            threeH.list.map {
                listWeatherForecast.add(
                    WeatherForecast(
                        threeH.city?.name ?: "",
                        it.weather[0].description,
                        it.main.tempMax,
                        it.main.tempMin,
                        it.main.feelsLike,
                        it.timeForecasts,
                        it.dt
                    )
                )
            }

        }
        return listWeatherForecast
    }

}