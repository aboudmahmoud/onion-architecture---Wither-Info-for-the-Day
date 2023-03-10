package com.example.weatherui.di

import com.example.data.remote.ApiServies
import com.example.weatherui.util.Const.BASE_URL
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn


import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun proivideOkHttpcline(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .addNetworkInterceptor { chain ->
                val builder: Request.Builder = chain.request().newBuilder()

                //builder.addHeader("Content-Type", "multipart/form-data")
                val request: Request = builder.build()
                val response: okhttp3.Response = chain.proceed(request)
                response
            }
            .followRedirects(false).build()
    }


    @ExperimentalSerializationApi
    @Singleton
    @Provides
    fun provideRetfit(okHttpClient: OkHttpClient): Retrofit {
        val connectionType= "application/json".toMediaType()
        //We didnt Recive AllData So We Igonire it
        val json = Json {
            ignoreUnknownKeys = true

        }
        return Retrofit.Builder().client(
            okHttpClient
        ).baseUrl(BASE_URL)
            .addConverterFactory(json.asConverterFactory(connectionType)).addConverterFactory(
                GsonConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().serializeNulls().create())).build()
    }
    @Singleton
    @Provides
    fun provideApiSevris(retrofit: Retrofit): ApiServies{
        return  retrofit.create(ApiServies::class.java)
    }

}