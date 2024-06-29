package com.minhnguyen.domain.interactors

import com.example.models.WeatherForecast
import com.minhnguyen.domain.SubjectInteractor
import com.minhnguyen.forecasts.ForecastsByCityRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import java.sql.Date
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import javax.inject.Inject

class GetForecasts5D3H @Inject constructor(
    private val forecastsByCityRepository: ForecastsByCityRepository
): SubjectInteractor<GetForecasts5D3H.Params, List<WeatherForecast>>() {
    override fun createObservable(params: Params): Flow<List<WeatherForecast>> {
        return forecastsByCityRepository
            .getForecastsByCity(params.cityName)
            .map {
                filterDateTime(it)
            }
    }

    private fun filterDateTime(data: List<WeatherForecast>): List<WeatherForecast> {
        val calendar = Calendar.getInstance()
        var currentTime = calendar.timeInMillis
        val offset = Calendar.getInstance().timeZone.getOffset(currentTime)
        currentTime -= offset
        val gapTime = currentTime + 24*60*60*1000
        println("nhbm offset = $offset")
        println("nhbm current time = ${System.currentTimeMillis()} calendarTime = $currentTime")
        return data.filter {
            it.timeStamp*1000L >= currentTime
                    && it.timeStamp*1000 <= gapTime
        }
    }

    data class Params(val cityName: String)

}