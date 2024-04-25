package com.minhnguyen.forecasts

import com.example.db.daos.ForecastDao
import com.example.models.WeatherForecast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ForecastsByCityRepository @Inject constructor(
    private val remoteDataSource: DefaultForecastByCityDataSource,
    private val forecastByCityDao: ForecastDao,
    private val mapper: NetworkToUIForecasts
) : ForecastsRepository{
    override fun getForecastsByCity(city: String) =
        forecastByCityDao.forecastWithCityName("%$city%")

    override suspend fun syncData(city: String): Boolean {
        println("nhbm syncData ct = $city")
        withContext(Dispatchers.IO) {
            val forecasts = remoteDataSource.getForecast(city)
            println("nhbm remote data = $forecasts")
            forecastByCityDao.insertAll(
                mapper.map(forecasts)
            )
        }
        return true
    }

}