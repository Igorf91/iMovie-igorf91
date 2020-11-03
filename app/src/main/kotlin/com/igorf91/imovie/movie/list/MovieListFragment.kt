package com.igorf91.imovie.movie.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.igorf91.imovie.R
import com.igorf91.imovie.adapter.MediaListAdapter
import kotlinx.android.synthetic.main.fragment_movie_list.movies_list_recycler_view

class MovieListFragment : Fragment(R.layout.fragment_movie_list) {

    private val adapter = MediaListAdapter()
    private lateinit var movieListViewModel: MovieListViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movieListViewModel = ViewModelProvider(this, MovieListViewModelFactory(MovieListRepository()))
            .get(MovieListViewModel::class.java)

        setupRecyclerView()
        setupListeners()
        setupCall()
    }

    private fun setupRecyclerView() {
        movies_list_recycler_view.adapter = adapter
        movies_list_recycler_view.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun setupListeners() {
        movieListViewModel.getMovieList().observe(viewLifecycleOwner, Observer {
            adapter.loadItems(it ?: emptyList())
        })
    }

    private fun setupCall() {
        movieListViewModel.fetchPopularMovieList()
    }
}
