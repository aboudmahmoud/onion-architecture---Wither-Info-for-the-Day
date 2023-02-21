package com.example.data.remote

import com.example.domain.entity.WitherInfo
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query


interface ApiServies {

    @GET("data/2.5/weather?lat=25.276987&lon=55.296249")
    suspend fun getWither(
        @Query("appid") appid:String
    ): WitherInfo
}