package com.igorf91.imovie.di

import com.igorf91.imovie.movie.list.MovieListRepository
import com.igorf91.imovie.movie.list.MovieListViewModel
import com.igorf91.imovie.network.TheMovieDbApi
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.themoviedb.org/3/"

val viewModelModule = module {
    viewModel {
        MovieListViewModel(get())
    }
}

val repositoryModule = module {
    single {
        MovieListRepository(get())
    }
}

val networkModule = module {
    single<TheMovieDbApi> {
        get<Retrofit>().create(TheMovieDbApi::class.java)
    }

    single<Retrofit> {
        val client = OkHttpClient.Builder().addInterceptor { chain ->
            var request = chain.request()
            val url = request.url()
                .newBuilder()
                .addQueryParameter("api_key", "change_api_key")
                .addQueryParameter("language", "pt-BR")
                .build()

            request = request
                .newBuilder()
                .url(url)
                .build()

            chain.proceed(request)
        }.build()

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
