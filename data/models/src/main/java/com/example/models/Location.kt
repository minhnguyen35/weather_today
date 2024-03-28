package com.example.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Locations")
data class Location(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    override val id: Long,
    @ColumnInfo(name="lat")
    val lat: Double,
    @ColumnInfo(name="lon")
    val lon: Double
) : WeatherEntity {
}