package com.minhnguyen.syncinformation.di

import com.minhnguyen.syncinformation.LocalSyncInformationRepository
import com.minhnguyen.syncinformation.SyncInformationRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    internal abstract fun bindSyncInformationRepository(
        syncInformation: LocalSyncInformationRepository
    ): SyncInformationRepository
}