package com.igorf91.imovie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.igorf91.imovie.R
import com.igorf91.imovie.vo.VideoVo

class ListItemAdapter : RecyclerView.Adapter<ListItemViewHolder>() {

    private var videoList: ArrayList<VideoVo> = arrayListOf()

    fun loadItems(newList: List<VideoVo>) {
        videoList = ArrayList(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_list_item, parent, false)
        return ListItemViewHolder(view)
    }

    override fun getItemCount() = videoList.size

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        val item = videoList[position]
        holder.bindView(item)
    }
}