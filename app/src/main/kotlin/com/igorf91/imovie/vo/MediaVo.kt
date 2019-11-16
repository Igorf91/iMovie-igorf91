package com.igorf91.imovie.vo

import com.google.gson.annotations.SerializedName

class MediaVo (
    @SerializedName("id")
    val id: Long,
    @SerializedName("poster_path")
    val poster: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("release_date")
    val year: String
)