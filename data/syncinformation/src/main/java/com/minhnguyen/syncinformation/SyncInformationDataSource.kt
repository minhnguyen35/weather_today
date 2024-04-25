package com.minhnguyen.syncinformation

import com.example.models.SyncInformation
import kotlinx.coroutines.flow.Flow

interface SyncInformationDataSource {
    fun getAttribute(attribute: String) : Flow<SyncInformation>
}