package com.mvvmwithdagger.data.remote

import com.mvvmwithdagger.utils.SharedPreference
import com.google.android.datatransport.BuildConfig
import com.google.gson.GsonBuilder
import com.mvvmwithdagger.utils.AuthInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClientInstance {
    private var retrofit: Retrofit? = null
    fun getRetrofitInstance(sharedPreference: SharedPreference): Retrofit? {
        if (retrofit == null) {
            val okHttpClient = OkHttpClient
                .Builder().apply {
                    addInterceptor(AuthInterceptor(sharedPreference))
                    if (BuildConfig.DEBUG) {
                        addInterceptor(HttpLoggingInterceptor().apply {
                            level = HttpLoggingInterceptor.Level.BODY
                        })
                    }
                }
                .connectTimeout(100, TimeUnit.SECONDS)
                .writeTimeout(100, TimeUnit.SECONDS)
                .readTimeout(100, TimeUnit.SECONDS)
                .build()
            retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(
                    GsonBuilder()
                        .setLenient()
                        .create()))
                .client(okHttpClient)
                .baseUrl("http://api.link.in/")
                .build()
        }
        return retrofit
    }
}