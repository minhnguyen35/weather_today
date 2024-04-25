package com.example.db.db

import com.example.db.daos.ForecastDao
import com.example.db.daos.SyncDataDao

interface ForecastDatabase {
    fun forecastByCityDao(): ForecastDao
    fun syncDataDao(): SyncDataDao
}