package com.igorf91.imovie.movie.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.igorf91.imovie.R
import com.igorf91.imovie.adapter.MediaListAdapter
import kotlinx.android.synthetic.main.fragment_movie_list.movies_list_recycler_view

class MovieListFragment : Fragment() {

    private val adapter = MediaListAdapter()
    private lateinit var movieListViewModel: MovieListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        movieListViewModel = ViewModelProviders
            .of(this, MovieListViewModelFactory(MovieListRepository()))
            .get(MovieListViewModel::class.java)

        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        setupListeners()
        setupCall()
    }

    private fun setupRecyclerView() {
        movies_list_recycler_view.adapter = adapter
        movies_list_recycler_view.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun setupListeners() {
        movieListViewModel.getMovieList().observe(this, Observer {
            adapter.loadItems(it ?: emptyList())
        })
    }

    private fun setupCall() {
        movieListViewModel.fetchPopularMovieList()
    }
}
