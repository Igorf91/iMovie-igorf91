package com.igorf91.imovie.vo

import com.google.gson.annotations.SerializedName

class MediaContainer (
    @SerializedName("page")
    val page: Long,
    @SerializedName("total_results")
    val totalResults: Long,
    @SerializedName("total_pages")
    val totalPages: Long,
    @SerializedName("results")
    val results: List<MediaVo>
)