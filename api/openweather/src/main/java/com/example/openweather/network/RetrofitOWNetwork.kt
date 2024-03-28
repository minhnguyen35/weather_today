package com.example.openweather.network

import com.example.openweather.OWNetworkDataSource
import com.example.openweather.models.Network3HoursForecast
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import okhttp3.Call
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

private const val path = "/data/2.5/forecast"

private interface RetrofitOWNetworkApi {
    @GET(value = "$path")
    suspend fun getForecastsByCityName(
        @Query("q") cityName: String,
        @Query("appid") apiKey: String
    ): NetworkResponse<List<Network3HoursForecast>>
}

@Serializable
private data class NetworkResponse<T>(
    val data: T,
)

@Singleton
class RetrofitOWNetwork @Inject constructor(
    networkJson: Json,
    okHttpClientFactory: dagger.Lazy<Call.Factory>,
    @Named("host") host: String,
    @Named("openweather-api") val apiKey: String
): OWNetworkDataSource{
    private val networkApi = Retrofit.Builder()
        .baseUrl(host)
        .callFactory {
            okHttpClientFactory.get().newCall(it)
        }
        .addConverterFactory(
            networkJson.asConverterFactory("application/json".toMediaType())
        )
        .build()
        .create(RetrofitOWNetworkApi::class.java)
    override suspend fun getForecastsByCityName(city: String): List<Network3HoursForecast> =
         networkApi.getForecastsByCityName(city, apiKey).data

}