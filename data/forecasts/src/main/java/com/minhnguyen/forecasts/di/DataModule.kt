package com.minhnguyen.forecasts.di

import com.minhnguyen.forecasts.DefaultForecastByCityDataSource
import com.minhnguyen.forecasts.ForecastByCityDataSource
import com.minhnguyen.forecasts.ForecastsByCityRepository
import com.minhnguyen.forecasts.ForecastsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    abstract fun bindWeatherByCityDataSource(source: DefaultForecastByCityDataSource): ForecastByCityDataSource
    @Binds
    internal abstract fun bindForecastByCityRepository(
        cityRepository: ForecastsByCityRepository
    ): ForecastsRepository
}
//@InstallIn(SingletonComponent::class)
//@Module
//abstract class CityBinds {
//    @Binds
//    abstract fun bindWeatherByCityDataSource(source: DefaultForecastByCityDataSource): ForecastByCityDataSource
//}