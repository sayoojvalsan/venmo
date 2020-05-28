package com.venmo.home.ui

import androidx.lifecycle.*
import com.venmo.home.model.ITunesSearchResponse
import com.venmo.home.api.SearchRepository
import com.venmo.home.model.AlbumArtWork
import kotlinx.coroutines.Dispatchers
import timber.log.Timber
import java.util.*
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val searchRepository: SearchRepository
) : ViewModel() {


    data class Query(val originalInput: String, val  country: String, val startPosition : Int)
    private var data: MutableList<AlbumArtWork> = mutableListOf()
    private var query = MutableLiveData<Query>()
    val progressBarVisibility = MutableLiveData(false)

    fun setQuery(originalInput: String, country: String,  startPosition : Int) {
        val input = originalInput.toLowerCase(Locale.getDefault()).trim()
        if (input == query.value?.originalInput) {
            return
        }
        data.clear()
        query.value = Query(originalInput, country, startPosition)
    }

    val results : LiveData<List<AlbumArtWork>>  = query.switchMap { query ->
        liveData(context = viewModelScope.coroutineContext + Dispatchers.IO) {
            progressBarVisibility.postValue(true)
            Timber.d(query.toString())
            val searchResponse = searchRepository.search(searchText = query.originalInput, country = query.country, startPosition = data.size)
            if (searchResponse.isSuccessful) {
                data.addAll(searchResponse.body()!!.toAlbumArtWork())
                emit(data)
            } else {
                emit(emptyList<AlbumArtWork>())
            }
            progressBarVisibility.postValue(false)
        }
    }





private fun ITunesSearchResponse.toAlbumArtWork(): List<AlbumArtWork> {
    return if (this.results != null) this.results.map {
        AlbumArtWork(it.artistName, it.trackName, it.collectionName, it.artworkUrl100, it.trackId, it.collectionId)
    }
    else {
        emptyList()
    }
}

    fun loadMore(itemCount: Int) {
        query.value?.let {
            query.value  = Query(it.originalInput, it.country, itemCount)
        }
    }


}
