package com.example.marvel.data

import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

class ClientConfig {
    val rootUrl: HttpUrl = HttpUrl.parse("https://gateway.marvel.com")!!
    val okHttpClient: OkHttpClient.Builder.() -> OkHttpClient.Builder = {
        retryOnConnectionFailure(false)
        connectTimeout(15, TimeUnit.SECONDS)
        readTimeout(15, TimeUnit.SECONDS)
        writeTimeout(15, TimeUnit.SECONDS)
    }
}