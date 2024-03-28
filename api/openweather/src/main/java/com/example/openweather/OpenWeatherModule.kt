package com.example.openweather

import com.github.prominence.openweathermap.api.OpenWeatherMapClient
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
object OpenWeatherModule {
    @Singleton
    @Provides
    fun providesOpenWeather(
        @Named("openweather-api") apiKey: String
    ) : OpenWeatherMapClient{
        return OpenWeatherMapClient(apiKey)
    }
}