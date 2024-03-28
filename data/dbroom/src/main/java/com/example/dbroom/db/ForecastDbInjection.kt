package com.example.dbroom.db

import android.content.Context
import androidx.room.Room
import com.example.db.daos.ForecastDao
import com.example.db.db.DatabaseTransactionRunner
import com.example.db.db.ForecastDatabase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RoomDatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ): ForecastRoomDatabase {
        val builder = Room.databaseBuilder(context, ForecastRoomDatabase::class.java, "forecasts.db")
            .fallbackToDestructiveMigration()
        return builder.build()
    }
}

@InstallIn(SingletonComponent::class)
@Module
object DatabaseDaoModule {
    @Provides
    fun provideForecastByCityDao(db: ForecastDatabase): ForecastDao = db.forecastByCityDao()
}

@InstallIn(SingletonComponent::class)
@Module
abstract class DatabaseModuleBinds {
    @Binds
    abstract fun bindRoomDb(db: ForecastRoomDatabase): ForecastDatabase

    @Singleton
    @Binds
    abstract fun providesDbTransaction(transactionRunner: RoomDatabaseTransactionRunner): DatabaseTransactionRunner
}















