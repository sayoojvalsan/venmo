package com.venmo.home.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AlbumArtWork(
    val artistName: String,
    val songTitle: String,
    val albumTitle: String,
    val imageUrl: String
) : Parcelable