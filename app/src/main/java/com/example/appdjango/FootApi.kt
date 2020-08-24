package com.example.appdjango

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.Response


interface FootApi {

    @GET(  "/menu")
    suspend fun getMenu() : Response<List<FootResponseItem>>

    companion object{
        operator fun invoke() : FootApi{
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl( "http://192.168.215.105:8000/")
                .build()
                .create(FootApi::class.java)
        }
    }
}