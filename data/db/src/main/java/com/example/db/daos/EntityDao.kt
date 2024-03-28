package com.example.db.daos

import com.example.models.WeatherEntity

interface EntityDao<in E: WeatherEntity> {
    suspend fun insert(entity: E): Long
    suspend fun insertAll(vararg entity: E)
    suspend fun insertAll(entities: List<E>)
    suspend fun update(entity: E)
    suspend fun deleteEntity(entity: E): Int
    suspend fun withTransaction(tx: suspend () -> Unit)
}