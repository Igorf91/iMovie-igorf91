package com.igorf91.imovie.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.igorf91.imovie.util.getLoaderPlaceholder
import com.igorf91.imovie.vo.MediaVo
import kotlinx.android.synthetic.main.layout_list_item.view.img_poster
import kotlinx.android.synthetic.main.layout_list_item.view.item_description
import kotlinx.android.synthetic.main.layout_list_item.view.item_header

class MediaListViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val imagePoster = itemView.img_poster
    private val itemHeader = itemView.item_header
    private val itemDescription = itemView.item_description

    fun bindView(item: MediaVo){
        Glide
            .with(itemView)
            .load(item.poster)
            .placeholder(getLoaderPlaceholder(itemView.context))
            .apply(RequestOptions.circleCropTransform())
            .into(imagePoster)

        itemHeader.text = item.title
        itemDescription.text = item.plot

        itemView.setOnClickListener {
            //TODO navigate do details
        }
    }
}