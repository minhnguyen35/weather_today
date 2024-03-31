package com.example.dbroom.daos

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Transaction
import androidx.room.Update
import com.example.db.daos.EntityDao
import com.example.models.WeatherEntity

interface RoomEntityDao<in E: WeatherEntity>: EntityDao<E> {
    @Insert
    override suspend fun insert(entity: E): Long

    @Insert
    override suspend fun insertAll(vararg entity: E)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    override suspend fun insertAll(entities: List<E>)

    @Update
    override suspend fun update(entity: E)

    @Delete
    override suspend fun deleteEntity(entity: E): Int

    @Transaction
    override suspend fun withTransaction(tx: suspend () -> Unit) = tx()
}