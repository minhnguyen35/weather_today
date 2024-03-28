package com.example.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "Forecast"
)
data class WeatherForecast(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    override val id: Long,
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
): WeatherEntity{

}
