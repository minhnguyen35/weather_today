//package com.example.inject.city
//
//import com.minhnguyen.forecasts.DefaultForecastByCityDataSource
//import com.minhnguyen.forecasts.ForecastByCityDataSource
//import dagger.Binds
//import dagger.Module
//import dagger.hilt.InstallIn
//import dagger.hilt.components.SingletonComponent
//
//@InstallIn(SingletonComponent::class)
//@Module
//abstract class CityBinds {
//    @Binds
//    abstract fun bindWeatherByCityDataSource(source: DefaultForecastByCityDataSource): ForecastByCityDataSource
//}