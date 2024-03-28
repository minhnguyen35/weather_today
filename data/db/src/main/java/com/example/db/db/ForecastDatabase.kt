package com.example.db.db

import com.example.db.daos.ForecastDao

interface ForecastDatabase {
    fun forecastByCityDao(): ForecastDao
}