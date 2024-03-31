package com.minhnguyen.network.interceptors

import com.minhnguyen.weather.network.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class ApiInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        println("@@@ handle request url = ${request.url}")
        val urlWithAPI = request.url.toString() + "&appid=${BuildConfig.API_KEY}"
        val newReq = request.newBuilder().url(urlWithAPI).build()
        println("@@@ handle request url = ${newReq.url}")
        return chain.proceed(newReq)
    }
}