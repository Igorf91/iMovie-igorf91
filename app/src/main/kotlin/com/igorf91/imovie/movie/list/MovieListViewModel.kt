package com.igorf91.imovie.movie.list

import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.lifecycle.ViewModel

class MovieListViewModel(private val repository: MovieListRepository) : ViewModel() {

    fun getMovieList() = repository.movieList
    fun fetchPopularMovieList() = repository.fetchPopularMovieList()

    fun listenerSearch() = TextView.OnEditorActionListener { textView, actionId, _ ->
        if (actionId == EditorInfo.IME_NULL || actionId == EditorInfo.IME_ACTION_DONE)
            filter(textView.text.toString())

        true
    }

    private fun filter(value: String) {
        repository.filterList(value)
    }

    fun searchTextChanger() = object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            // empty
        }
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            // empty
        }
        override fun afterTextChanged(s: Editable?) {
            if (s.isNullOrBlank())
                repository.fetchPopularMovieList()
        }
    }
}