package com.example.db.daos

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.models.SyncInformation
import kotlinx.coroutines.flow.Flow

abstract class SyncDataDao: EntityDao<SyncInformation> {
    abstract fun getAttribute(attribute: String): Flow<SyncInformation>
}
