package com.minhnguyen.syncinformation

import com.example.models.SyncInformation
import kotlinx.coroutines.flow.Flow

interface SyncInformationRepository {
    fun getAttribute(attribute: String): Flow<SyncInformation>
    suspend fun<T> saveAttribute(attribute: String, value: T)
}