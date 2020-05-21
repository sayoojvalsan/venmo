package com.venmo.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.venmo.di.Injectable
import com.venmo.di.injectActivityViewModel
import com.venmo.home.R
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

class HomeFragment : Fragment(), Injectable {

    private lateinit var albumArtRecyclerViewAdapter: AlbumArtRecyclerViewAdapter
    private lateinit var homeViewModel: HomeViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        homeViewModel = injectActivityViewModel(viewModelFactory)

        val root = inflater.inflate(R.layout.fragment_home, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        homeViewModel.setQuery("Beetles", "US")

        homeViewModel.albumArtWorkSearchResults.observe(viewLifecycleOwner, Observer {
            albumArtRecyclerViewAdapter.albumArtList = it
            albumArtRecyclerViewAdapter.notifyDataSetChanged()
        })
    }

    private fun initRecyclerView() {
        albumArtRecyclerViewAdapter = AlbumArtRecyclerViewAdapter()
        val linearLayoutManager = LinearLayoutManager(activity?.applicationContext)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        album_art_recyclerview.adapter = albumArtRecyclerViewAdapter
        album_art_recyclerview.layoutManager = linearLayoutManager
    }


}
