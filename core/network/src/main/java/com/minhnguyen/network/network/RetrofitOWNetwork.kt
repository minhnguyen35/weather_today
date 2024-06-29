package com.minhnguyen.network.network

import com.minhnguyen.network.models.Network3HoursForecast
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.minhnguyen.network.OWNetworkDataSource
import com.minhnguyen.weather.network.BuildConfig
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import okhttp3.Call
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

private const val BASE_URL = BuildConfig.HOST
private const val path = "/data/2.5/forecast"

private interface RetrofitOWNetworkApi {
    @GET(value = path)
    suspend fun getForecastsByCityName(
        @Query("q") cityName: String,
    ): Network3HoursForecast
}

@Serializable
private data class NetworkResponse<T>(
    val data: T
)

@Singleton
class RetrofitOWNetwork @Inject constructor(
    networkJson: Json,
    okHttpClientFactory: dagger.Lazy<Call.Factory>,
): OWNetworkDataSource {
    private val networkApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .callFactory {
            okHttpClientFactory.get().newCall(it)
        }
        .addConverterFactory(
            networkJson.asConverterFactory("application/json".toMediaType())
        )
        .build()
        .create(RetrofitOWNetworkApi::class.java)
    override suspend fun getForecastsByCityName(city: String): Network3HoursForecast {
        val res = networkApi.getForecastsByCityName(city)
        println("nhbm res = ${res.message}")
        return res
    }

}