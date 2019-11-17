package com.igorf91.imovie.movie.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.igorf91.imovie.R
import com.igorf91.imovie.util.formatDate
import com.igorf91.imovie.util.loadImage
import com.igorf91.imovie.vo.MediaVo
import kotlinx.android.synthetic.main.fragment_movie_detail.img_mov_detail_poster
import kotlinx.android.synthetic.main.fragment_movie_detail.txt_description_mov_detail
import kotlinx.android.synthetic.main.fragment_movie_detail.txt_title_mov_detail
import kotlinx.android.synthetic.main.fragment_movie_detail.txt_year_mov_detail

class MovieDetailFragment : Fragment() {

    private val movieDetailArgs: MovieDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupLayout(movieDetailArgs.mediaVo)
    }

    private fun setupLayout(media: MediaVo) {
        img_mov_detail_poster.loadImage(media.poster, this)

        txt_title_mov_detail.text = media.title
        txt_year_mov_detail.text = media.year.formatDate()
        txt_description_mov_detail.text = media.overview
    }

}
