package com.minhnguyen.forecasts

import com.example.db.daos.ForecastDao
import com.example.models.WeatherForecast
import com.minhnguyen.network.models.NetworkWeatherForecast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

class ForecastsByCityRepository @Inject constructor(
    private val remoteDataSource: DefaultForecastByCityDataSource,
    private val forecastByCityDao: ForecastDao,
    private val mapper: NetworkToUIForecasts
) : ForecastsRepository{
    override suspend fun getForecastsByCity(city: String) =
        forecastByCityDao.forecastWithCityName(city)

    override suspend fun syncData(city: String): Boolean {
        withContext(Dispatchers.IO) {
            val forecasts = remoteDataSource.getForecast(city)
            forecastByCityDao.insertAll(
                mapper.map(forecasts)
            )
        }
        return true
    }

}