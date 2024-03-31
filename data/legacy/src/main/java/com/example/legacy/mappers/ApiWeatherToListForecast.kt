//package com.example.legacy.mappers
//
//import com.example.models.WeatherForecast
//import javax.inject.Inject
//
//class ApiWeatherToListForecast @Inject constructor(): Mapper<Network, List<WeatherForecast>> {
//    override suspend fun map(from: Forecast) = from.weatherForecasts.map {
//        println("minh.nguyen forecast = $it")
//        WeatherForecast(
//            id = 0,
//            city = from.location.name,
//            description = it.weatherState.description,
//            maxTemperature = it.temperature.maxTemperature,
//            minTemperature = it.temperature.minTemperature,
//            feelsLikeTemperature = it.temperature.feelsLike
//        )
//    }.toList()
//}