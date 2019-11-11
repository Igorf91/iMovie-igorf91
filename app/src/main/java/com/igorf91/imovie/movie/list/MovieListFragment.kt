package com.igorf91.imovie.movie.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.igorf91.imovie.R
import com.igorf91.imovie.adapter.ListItemAdapter
import kotlinx.android.synthetic.main.fragment_movie_list.movies_list_recycler_view

class MovieListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        movies_list_recycler_view.adapter = ListItemAdapter()
        movies_list_recycler_view.layoutManager = LinearLayoutManager(requireContext())
    }
}
