package com.igorf91.imovie.movie.list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.igorf91.imovie.network.TheMovieDbApi
import com.igorf91.imovie.util.callback
import com.igorf91.imovie.vo.MediaVo

class MovieListRepository(private val api: TheMovieDbApi) {

    private var _movieList = MutableLiveData<List<MediaVo>>()
    val movieList: LiveData<List<MediaVo>> = _movieList

    companion object {
        private const val LOCAL_TAG = "MovieListRepository"
        private const val TYPE = "movie"
    }

    fun fetchPopularMovieList() {
        api.getPopularMediaByType(TYPE).enqueue(callback { response, throwable ->
            response?.let {
                response.body()?.let { _movieList.postValue(it.results) }
            }
            throwable?.let {
                Log.e(LOCAL_TAG, it.message?:"EMPTY RESPONSE")
            }
        })
    }
}