package com.igorf91.imovie.movie.list

import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.igorf91.imovie.R
import com.igorf91.imovie.adapter.MediaListAdapter
import kotlinx.android.synthetic.main.fragment_movie_list.movie_list_search_edit_text
import kotlinx.android.synthetic.main.fragment_movie_list.movie_list_voice_search
import kotlinx.android.synthetic.main.fragment_movie_list.movies_list_recycler_view
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class MovieListFragment : Fragment(R.layout.fragment_movie_list) {

    private val adapter = MediaListAdapter()
    private val movieListViewModel by viewModel<MovieListViewModel>()

    companion object {
        private const val VOICE_REQUEST_CODE = 9874
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
        movieListViewModel.getMovieList().observe(viewLifecycleOwner, {
            adapter.loadItems(it ?: emptyList())
        })

        movie_list_search_edit_text.setOnEditorActionListener(movieListViewModel.listenerSearch())
        movie_list_search_edit_text.addTextChangedListener(movieListViewModel.searchTextChanger())

        movie_list_voice_search.setOnClickListener {
            val voiceIntent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).also {
                it.putExtra(
                    RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                    RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
                )
                it.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
            }

            startActivityForResult(voiceIntent, VOICE_REQUEST_CODE)
        }
    }

    private fun setupCall() {
        movieListViewModel.fetchPopularMovieList()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == VOICE_REQUEST_CODE && data != null) {
            val result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
            movie_list_search_edit_text.setText(result?.first())
        }
    }
}
