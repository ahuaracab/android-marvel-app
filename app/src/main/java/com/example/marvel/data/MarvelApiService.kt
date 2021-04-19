package com.example.marvel.data

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal class MarvelApiService(
    private val config: ClientConfig
) : MarvelApiInterface by Retrofit.Builder()
    .baseUrl(config.rootUrl)
    .addConverterFactory(GsonConverterFactory.create())
    .client(OkHttpClient.Builder().(config.okHttpClient)().build())
    .build()
    .create(MarvelApiInterface::class.java){
}