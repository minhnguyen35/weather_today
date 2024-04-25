package com.minhnguyen.syncinformation

import com.example.db.daos.SyncDataDao
import com.example.models.SyncInformation
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalSyncInformationRepository @Inject constructor(
    private val dao: SyncDataDao
): SyncInformationRepository {
    override fun getAttribute(attribute: String): Flow<SyncInformation>
        = dao.getAttribute(attribute)

    override suspend fun<T> saveAttribute(attribute: String, value: T) {
        when(value) {
            is Int -> {
                dao.insert(SyncInformation(attribute, "$value", "Int"))
            }
            is Long -> {
                dao.insert(SyncInformation(attribute, "$value", "Long"))
            }
            is String -> {
                dao.insert(SyncInformation(attribute, value, "String"))
            }
            is Boolean -> {
                dao.insert(SyncInformation(attribute, "$value", "Boolean"))
            }
        }
    }
}