package com.example.myui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.models.WeatherForecast
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

    private fun mappingState(forecasts: List<WeatherForecast>) : HomeScreenState{
        val currentTime = System.currentTimeMillis()

        val forecastsFrom = forecasts.filter {
            it.timeStamp*1000L >= currentTime
        }.take(10)

        println("nhbm todayForecast ${forecastsFrom.map { it.forecastTime }}")
        val pattern = "yyyy-MM-dd HH:mm"
        val simpleDateFormat = SimpleDateFormat(pattern).format(Date(currentTime))
        if(forecastsFrom.isEmpty())
            return HomeScreenState.Empty
//        val todayTimestamp = Date()
        return HomeScreenState(
            cityName = default_city,
            avgTemperature = "${forecastsFrom[0].feelsLikeTemperature}°F",
            maxTemperature = "${forecastsFrom[0].maxTemperature}°F",
            minTemperature = "${forecastsFrom[0].minTemperature}°F",
            dayTimestamp= simpleDateFormat,
            descriptionForecast = forecastsFrom[0].description,
            todayForecasts = forecastsFrom)
    }

    private fun filterDateTime(data: List<WeatherForecast>, currentTime: Long): List<WeatherForecast> {
        val currentCalendar = Calendar.getInstance(Locale("vi","VN"))
        val year = currentCalendar.get(Calendar.YEAR)
        val month = currentCalendar.get(Calendar.MONTH)
        val day = currentCalendar.get(Calendar.DATE)
        println("nhbm year = $year month = $month day = $day")
        currentCalendar.set(year, month, day + 1, 0, 0, 0)
        return data.filter {
            it.timeStamp*1000L >= currentTime
                    && it.timeStamp*1000L <= currentCalendar.time.time
        }
    }

    init {
        println("nhbm syncData init")
        viewModelScope.launch (Dispatchers.IO){
            syncForecastData(SyncForecastData.Params(default_city)).collectLatest {
                println("nhbm status = $it")
            }
            observeForecasts5D3H(GetForecasts5D3H.Params(default_city))
        }
    }

}