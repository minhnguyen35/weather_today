package com.example.weathertoday.inject

import com.example.openweather.OpenWeatherModule
import com.example.weathertoday.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@InstallIn(SingletonComponent::class)
@Module(
    includes = [
        OpenWeatherModule::class
    ]
)
object AppModule {
    @Provides
    @Named("openweather-api")
    fun provideOpenWeatherApiKey(): String = BuildConfig.API_KEY

    @Provides
    @Named("host")
    fun provideHost(): String = BuildConfig.HOST
}