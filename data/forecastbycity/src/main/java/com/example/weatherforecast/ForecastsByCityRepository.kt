package com.example.weatherforecast

import com.example.db.daos.ForecastDao
import com.example.models.WeatherForecast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ForecastsByCityRepository @Inject constructor(
    private val remoteDataSource: DefaultForecastByCityDataSource,
    private val forecastByCityDao: ForecastDao
) {
    suspend fun getForecastsByCity(city: String) : List<WeatherForecast>{
        coroutineScope {
            println("minh.nguyen getForecastsByCity city = $city")
            val response = async(Dispatchers.IO) {
                remoteDataSource.getForecast(city)
            }

            val data = response.await()
            println("minh.nguyen getForecastsByCity data = $data")
        }

        return forecastByCityDao.forecastWithCityName(city)
    }
}