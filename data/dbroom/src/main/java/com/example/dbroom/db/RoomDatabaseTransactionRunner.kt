package com.example.dbroom.db

import androidx.room.withTransaction
import com.example.db.db.DatabaseTransactionRunner
import javax.inject.Inject

class RoomDatabaseTransactionRunner @Inject constructor(
    private val db: ForecastRoomDatabase
): DatabaseTransactionRunner {
    override suspend fun <T> invoke(block: () -> T): T {
        return db.withTransaction {
            block()
        }
    }
}