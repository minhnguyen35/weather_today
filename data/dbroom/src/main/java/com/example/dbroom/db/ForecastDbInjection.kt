package com.example.dbroom.db

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.db.daos.ForecastDao
import com.example.db.daos.SyncDataDao
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
        val MIGRATION_2_3 = object : Migration(2, 3) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("DROP TABLE Forecast")
            }
        }

        val builder = Room.databaseBuilder(context,
                    ForecastRoomDatabase::class.java, "forecasts.db")
            .addMigrations(MIGRATION_2_3)
            .addCallback(PrepopulateCitiesCallback(context))
            .fallbackToDestructiveMigration()
        return builder.build()
    }
}

@InstallIn(SingletonComponent::class)
@Module
object DatabaseDaoModule {
    @Provides
    fun provideForecastByCityDao(db: ForecastDatabase): ForecastDao = db.forecastByCityDao()

    @Provides
    fun provideSyncDataDao(db: ForecastDatabase): SyncDataDao = db.syncDataDao()
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















