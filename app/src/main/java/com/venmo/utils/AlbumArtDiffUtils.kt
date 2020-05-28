package com.venmo.utils

import androidx.recyclerview.widget.DiffUtil.ItemCallback
import com.venmo.home.model.AlbumArtWork

class AlbumArtDiffUtils : ItemCallback<AlbumArtWork>() {
    override fun areItemsTheSame(oldItem: AlbumArtWork, newItem: AlbumArtWork): Boolean {
        return oldItem.trackID == newItem.trackID && oldItem.collectionID == newItem.collectionID
    }

    override fun areContentsTheSame(oldItem: AlbumArtWork, newItem: AlbumArtWork): Boolean {
        return oldItem.albumTitle == newItem.albumTitle && newItem.trackName == oldItem.trackName && oldItem.artistName == newItem.artistName

    }
}