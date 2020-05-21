package com.venmo.home.ui

import android.app.Activity
import android.content.Context
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.venmo.home.R
import com.venmo.home.model.AlbumArtWork


class AlbumArtRecyclerViewAdapter :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var albumArtList: List<AlbumArtWork> = emptyList()

    override fun onCreateViewHolder(
         parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val rootView: View = LayoutInflater.from(parent.context).inflate(R.layout.albumartitem, parent, false)
        return RecyclerViewViewHolder(rootView)
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {
        val albumArtWork: AlbumArtWork =
            albumArtList[position]
        val viewHolder =
            holder as RecyclerViewViewHolder
        viewHolder.txtView_title.text = albumArtWork.albumTitle
        viewHolder.txtView_description.text = albumArtWork.artistName
    }

    override fun getItemCount(): Int {
        return albumArtList.size
    }

    internal inner class RecyclerViewViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var imgView_icon: ImageView = itemView.findViewById(R.id.imgView_icon)
        var txtView_title: TextView = itemView.findViewById(R.id.txtView_title)
        var txtView_description: TextView = itemView.findViewById(R.id.txtView_description)

    }

}