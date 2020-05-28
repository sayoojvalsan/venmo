package com.venmo.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_album_details.*


class AlbumDetailsFragment : Fragment() {
    val args: AlbumDetailsFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_album_details, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val albumArtWork = args.albumArtWork
        albumArtist.text = albumArtWork.artistName
        albumTitle.text = albumArtWork.albumTitle
        Glide.with(this).load(albumArtWork.imageUrl).into(albumArt)

    }
}
