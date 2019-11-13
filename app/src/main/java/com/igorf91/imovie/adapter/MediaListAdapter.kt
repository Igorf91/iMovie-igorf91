package com.igorf91.imovie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.igorf91.imovie.R
import com.igorf91.imovie.vo.MediaVo

class MediaListAdapter : RecyclerView.Adapter<MediaListViewHolder>() {

    private var mediaList: ArrayList<MediaVo> = arrayListOf()

    fun loadItems(newList: List<MediaVo>) {
        mediaList = ArrayList(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MediaListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_list_item, parent, false)
        return MediaListViewHolder(view)
    }

    override fun getItemCount() = mediaList.size

    override fun onBindViewHolder(holderMedia: MediaListViewHolder, position: Int) {
        val item = mediaList[position]
        holderMedia.bindView(item)
    }
}