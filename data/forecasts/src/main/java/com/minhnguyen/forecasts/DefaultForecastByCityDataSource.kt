package com.minhnguyen.forecasts

import com.example.legacy.mappers.withRetry
import com.minhnguyen.network.OWNetworkDataSource
import com.minhnguyen.network.models.Network3HoursForecast
import javax.inject.Inject

class DefaultForecastByCityDataSource @Inject constructor(
    private val weatherApi: OWNetworkDataSource,
): ForecastByCityDataSource {

    override suspend fun getForecast(city: String) : Network3HoursForecast {
        return withRetry {
            weatherApi.getForecastsByCityName(city)
        }
    }
}