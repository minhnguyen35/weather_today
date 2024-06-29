package com.example.myui

import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.base.InvokeError
import com.example.models.WeatherForecast
import com.minhnguyen.domain.interactors.DeleteOutdatedCache
import com.minhnguyen.domain.interactors.GetForecasts5D3H
import com.minhnguyen.domain.interactors.SyncForecastData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.sql.Date
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltViewModel
class ForecastsByCityViewModel @Inject constructor(
    observeForecasts5D3H: GetForecasts5D3H,
    syncForecastData: SyncForecastData,
    deleteOutdatedCache: DeleteOutdatedCache
) : ViewModel(){

    companion object {
        private const val default_city = "Ho Chi Minh"
    }

    val state : StateFlow<HomeScreenState> = observeForecasts5D3H.flow
        .map {
            mappingState(it)
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = HomeScreenState.Empty
        )

    private fun mappingState(forecastsFrom: List<WeatherForecast>) : HomeScreenState{
        if(forecastsFrom.isEmpty())
            return HomeScreenState.Empty
        val currentTime = System.currentTimeMillis()
        val pattern = "yyyy-MM-dd HH:mm"
        val simpleDateFormat = SimpleDateFormat(pattern).format(Date(currentTime))
        return HomeScreenState(
            cityName = default_city,
            avgTemperature = "${forecastsFrom[0].feelsLikeTemperature}°F",
            maxTemperature = "${forecastsFrom[0].maxTemperature}°F",
            minTemperature = "${forecastsFrom[0].minTemperature}°F",
            dayTimestamp= simpleDateFormat,
            descriptionForecast = forecastsFrom[0].description,
            todayForecasts = forecastsFrom)
    }

    init {
        println("nhbm syncData init")
        viewModelScope.launch (Dispatchers.IO){
            syncForecastData(SyncForecastData.Params(default_city)).collectLatest {
                println("nhbm status = $it")
                if(it is InvokeError) {
                    println("InvokeError: ${it.throwable.message}")
                }
            }
            deleteOutdatedCache(Unit)
            observeForecasts5D3H(GetForecasts5D3H.Params(default_city))
        }
    }

}