package com.igorf91.imovie.movie.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MovieListViewModel(private val repository: MovieListRepository) : ViewModel(){

    fun getMovieList() = repository.movieList
    fun fetchPopularMovieList() = repository.fetchPopularMovieList()
}

class MovieListViewModelFactory(private val repository: MovieListRepository)
    : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MovieListViewModel(repository) as T
    }
}