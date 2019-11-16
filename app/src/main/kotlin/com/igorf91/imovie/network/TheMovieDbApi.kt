package com.igorf91.imovie.network

import com.igorf91.imovie.vo.MediaContainer
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface TheMovieDbApi {

    @GET("{type}/popular")
    fun getPopularMediaByType(@Path("type") type: String): Call<MediaContainer>
}