package com.example.dbroom.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.db.daos.SyncDataDao
import com.example.models.SyncInformation
import kotlinx.coroutines.flow.Flow

@Dao
abstract class RoomSyncDataDao: SyncDataDao(), RoomEntityDao<SyncInformation> {
    @Query("SELECT * FROM SyncData WHERE attribute = :attribute")
    abstract override fun getAttribute(attribute: String): Flow<SyncInformation>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract override suspend fun insert(entity: SyncInformation): Long
}