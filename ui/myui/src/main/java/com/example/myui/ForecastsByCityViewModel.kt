package com.example.myui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.minhnguyen.forecasts.ForecastsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ForecastsByCityViewModel @Inject constructor(
    private val forecastRepo: ForecastsRepository
) : ViewModel(){

    init {
        println("minh.nguyen ForecastsByCityViewModel get forecasts...")
        getForecastsByCity()
    }
    val state = MutableStateFlow(0)

    private fun getForecastsByCity() {
        viewModelScope.launch (Dispatchers.IO){
            forecastRepo.getForecastsByCity("Ho Chi Minh").collect{
                it.forEach {forecast->
                    println("forecast = ${forecast.forecastTime} + ${forecast.description}")
                }
            }
        }
    }

    fun getForecasts() {
        getForecastsByCity()
    }
}