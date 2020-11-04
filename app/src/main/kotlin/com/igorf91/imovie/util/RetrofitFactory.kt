package com.igorf91.imovie.util

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {

    companion object {
        private const val BASE_URL = "https://api.themoviedb.org/3/"
    }

    private var client = OkHttpClient.Builder().addInterceptor { chain ->
        var request = chain.request()
        val url = request.url()
            .newBuilder()
            .addQueryParameter("api_key", "change_this_key")
            .addQueryParameter("language", "pt-BR")
            .build()

        request = request
            .newBuilder()
            .url(url)
            .build()

        chain.proceed(request)
    }.build()

    fun getRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}