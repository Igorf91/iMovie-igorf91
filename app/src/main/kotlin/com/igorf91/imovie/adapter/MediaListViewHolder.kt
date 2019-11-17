package com.igorf91.imovie.adapter

import android.view.View
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.igorf91.imovie.movie.list.MovieListFragmentDirections
import com.igorf91.imovie.util.formatDate
import com.igorf91.imovie.util.loadImage
import com.igorf91.imovie.vo.MediaVo
import kotlinx.android.synthetic.main.layout_list_item.view.img_poster
import kotlinx.android.synthetic.main.layout_list_item.view.item_description
import kotlinx.android.synthetic.main.layout_list_item.view.item_header
import kotlinx.android.synthetic.main.layout_list_item.view.item_header_date

class MediaListViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val imagePoster = itemView.img_poster
    private val itemHeader = itemView.item_header
    private val itemHeaderDate = itemView.item_header_date
    private val itemDescription = itemView.item_description

    fun bindView(item: MediaVo){
        imagePoster.loadImage(item.poster, itemView)

        itemHeader.text = item.title
        itemHeaderDate.text = item.year.formatDate()
        itemDescription.text = item.overview

        itemView.setOnClickListener {
            val action = MovieListFragmentDirections.actionMovieToDetail(item)
            itemView.findNavController().navigate(action)
        }
    }
}