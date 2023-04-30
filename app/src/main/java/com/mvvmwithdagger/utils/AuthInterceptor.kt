package com.mvvmwithdagger.utils

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Extentia
 * PUNE.
 */
class AuthInterceptor(private val sharedPreference: SharedPreference) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val requestBuilder = originalRequest.newBuilder().apply {
            header("Content-Type", "application/json")
            header("Authorization", ("Bearer "))
            header("Connection","close")
        }

        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}