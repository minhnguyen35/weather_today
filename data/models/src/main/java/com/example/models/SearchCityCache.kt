package com.example.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "SearchCity")
data class SearchCityCache(
    @PrimaryKey
    val cityName: String
)