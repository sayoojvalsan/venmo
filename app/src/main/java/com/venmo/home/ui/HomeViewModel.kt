package com.venmo.home.ui

import androidx.lifecycle.*
import com.venmo.home.model.ITunesSearchResponse
import com.venmo.home.api.SearchRepository
import com.venmo.home.model.AlbumArtWork
import kotlinx.coroutines.Dispatchers
import java.util.*
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val searchRepository: SearchRepository
) : ViewModel() {

    private lateinit var country: String
    private val query = MutableLiveData<String>()
//    private val nextPageHandler = NextPageHandler(searchRepository)


    fun setQuery(originalInput: String, country: String) {
        val input = originalInput.toLowerCase(Locale.getDefault()).trim()
        if (input == query.value) {
            return
        }
        this.country = country
        query.value = input
    }

    val results : LiveData<List<AlbumArtWork>>  = query.switchMap { query ->
        liveData(context = viewModelScope.coroutineContext + Dispatchers.IO) {
            val searchResponse = searchRepository.search(searchText = query, country = country)
            if (searchResponse.isSuccessful) {
                emit(searchResponse.body()!!.toAlbumArtWork())
            } else {
                emit(emptyList<AlbumArtWork>())
            }
        }
    }


private fun ITunesSearchResponse.toAlbumArtWork(): List<AlbumArtWork> {
    return if (this.results != null) this.results.map {
        AlbumArtWork(it.artistName, it.trackName, it.collectionName, it.artworkUrl100)
    }
    else {
        emptyList()
    }
}


}
