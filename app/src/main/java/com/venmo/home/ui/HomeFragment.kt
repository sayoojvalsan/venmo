package com.venmo.home.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.venmo.di.Injectable
import com.venmo.di.injectActivityViewModel
import com.venmo.home.R
import com.venmo.home.model.AlbumArtWork
import com.venmo.utils.OnLoadMoreListener
import com.venmo.utils.RecyclerViewLoadMoreScroll
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject


class HomeFragment : Fragment(), Injectable {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var scrollListener: RecyclerViewLoadMoreScroll
    private lateinit var albumArtRecyclerViewAdapter: AlbumArtRecyclerViewAdapter

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        homeViewModel = injectActivityViewModel(viewModelFactory)

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    @ExperimentalCoroutinesApi
    @InternalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        initSearch()
        initProgressbarVisibility()
        observeResults()
    }

    private fun observeResults() {
        homeViewModel.results.observe(viewLifecycleOwner, Observer {
            albumArtRecyclerViewAdapter.submitList(it.toList())
            scrollListener.setLoaded()
        })
    }

    private fun initProgressbarVisibility() {
        homeViewModel.progressBarVisibility.observe(viewLifecycleOwner, Observer {
            progressBar.isVisible = it
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
                delay(450)  //debounce timeOut
                if (searchText != searchFor)
                    return@launch
                homeViewModel.setQuery(searchText, getString(R.string.country), linearLayoutManager.itemCount)
            }
        }

        override fun afterTextChanged(s: Editable?) = Unit
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit
    }



    private fun initRecyclerView() {
        albumArtRecyclerViewAdapter = AlbumArtRecyclerViewAdapter(onItemClick ={
            val actionNavigationHomeSearchToAlbumDetailsFragment =
                HomeFragmentDirections.actionNavigationHomeSearchToAlbumDetailsFragment(it)
            findNavController().navigate(actionNavigationHomeSearchToAlbumDetailsFragment)

        })
        linearLayoutManager = LinearLayoutManager(activity?.applicationContext)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        album_art_recyclerview.adapter = albumArtRecyclerViewAdapter
        album_art_recyclerview.layoutManager = linearLayoutManager

        scrollListener = RecyclerViewLoadMoreScroll(linearLayoutManager)
        scrollListener.setOnLoadMoreListener(object : OnLoadMoreListener {
            override fun onLoadMore() {
                homeViewModel.loadMore(linearLayoutManager.itemCount)
            }
        })
        album_art_recyclerview.addOnScrollListener(scrollListener)
    }

}
