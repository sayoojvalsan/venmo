package com.venmo.home.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.venmo.di.Injectable
import com.venmo.di.injectActivityViewModel
import com.venmo.home.R
import com.venmo.home.model.AlbumArtWork
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import timber.log.Timber
import javax.inject.Inject



class HomeFragment : Fragment(), Injectable {
    private val queryChannel = BroadcastChannel<String>(Channel.CONFLATED)

    private lateinit var albumArtRecyclerViewAdapter: AlbumArtRecyclerViewAdapter
    private lateinit var homeViewModel: HomeViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var flow: Flow<String>


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        homeViewModel = injectActivityViewModel(viewModelFactory)

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    @InternalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        initSearch()

        homeViewModel.results.observe(viewLifecycleOwner, Observer {
            Timber.d("Got results $it")
            albumArtRecyclerViewAdapter.albumArtList = it
            albumArtRecyclerViewAdapter.notifyDataSetChanged()
        })
    }

    @InternalCoroutinesApi
    @ExperimentalCoroutinesApi
    private fun initSearch() {
        search_query.addTextChangedListener(watcher)
    }


    private val watcher = object : TextWatcher {
        private var searchFor = ""

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val searchText = s.toString().trim()
            if (searchText == searchFor)
                return

            searchFor = searchText

            lifecycleScope.launch {
                delay(300)  //debounce timeOut
                if (searchText != searchFor)
                    return@launch
                Timber.d(("Sending query $searchText"))
                homeViewModel.setQuery(searchText, "US")
            }
        }

        override fun afterTextChanged(s: Editable?) = Unit
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit
    }



    private fun initRecyclerView() {
        albumArtRecyclerViewAdapter = AlbumArtRecyclerViewAdapter(onItemClick ={
                it: AlbumArtWork ->
            val actionNavigationHomeSearchToAlbumDetailsFragment =
                HomeFragmentDirections.actionNavigationHomeSearchToAlbumDetailsFragment(it)
            findNavController().navigate(actionNavigationHomeSearchToAlbumDetailsFragment)

        })
        val linearLayoutManager = LinearLayoutManager(activity?.applicationContext)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        album_art_recyclerview.adapter = albumArtRecyclerViewAdapter
        album_art_recyclerview.layoutManager = linearLayoutManager

    }


}
