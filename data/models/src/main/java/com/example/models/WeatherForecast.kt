package com.example.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "Forecast",
    primaryKeys = ["city","timestamp"]
)
data class WeatherForecast(
    @ColumnInfo(name="city")
    val city: String,
    @ColumnInfo(name="description")
    val description: String,
    @ColumnInfo(name="max_temperature")
    val maxTemperature: Double,
    @ColumnInfo(name="min_temperature")
    val minTemperature: Double,
    @ColumnInfo(name="feels_like_temperature")
    val feelsLikeTemperature: Double,
    @ColumnInfo(name="forecast_time")
    val forecastTime: String,
    @ColumnInfo(name="timestamp")
    val timeStamp: Long
): WeatherEntity{

}
