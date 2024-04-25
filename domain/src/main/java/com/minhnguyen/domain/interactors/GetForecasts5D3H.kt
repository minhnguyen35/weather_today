package com.minhnguyen.domain.interactors

import com.example.models.WeatherForecast
import com.minhnguyen.domain.SubjectInteractor
import com.minhnguyen.forecasts.ForecastsByCityRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetForecasts5D3H @Inject constructor(
    private val forecastsByCityRepository: ForecastsByCityRepository
): SubjectInteractor<GetForecasts5D3H.Params, List<WeatherForecast>>() {
    override fun createObservable(params: Params): Flow<List<WeatherForecast>> {
        return forecastsByCityRepository.getForecastsByCity(params.cityName)
    }

    data class Params(val cityName: String)

}