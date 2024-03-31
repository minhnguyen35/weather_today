package com.minhnguyen.network.di

import com.minhnguyen.network.OWNetworkDataSource
import com.minhnguyen.network.interceptors.ApiInterceptor
import com.minhnguyen.network.network.RetrofitOWNetwork
import com.minhnguyen.weather.network.BuildConfig
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.Call
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun providesNetworkJson(): Json = Json {
        ignoreUnknownKeys = true
    }

    @Provides
    @Singleton
    fun okHttpCallFactory(): Call.Factory = OkHttpClient.Builder()
        .addInterceptor(
            HttpLoggingInterceptor()
                .apply {
                    if(BuildConfig.DEBUG)
                        setLevel(HttpLoggingInterceptor.Level.BODY)
                },
        )
        .addInterceptor(ApiInterceptor())
        .build()
}

@Module
@InstallIn(SingletonComponent::class)
internal interface FlavoredNetworkModule {

    @Binds
    fun binds(impl: RetrofitOWNetwork): OWNetworkDataSource
}
