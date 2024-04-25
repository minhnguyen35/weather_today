package com.minhnguyen.syncinformation

import com.example.models.SyncInformation
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalSyncInformationDataSource @Inject constructor(

): SyncInformationDataSource{
    override fun getAttribute(attribute: String): Flow<SyncInformation> {
        TODO("Not yet implemented")
    }
}