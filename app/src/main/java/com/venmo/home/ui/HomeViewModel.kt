package com.venmo.home.ui

import androidx.lifecycle.*
import com.venmo.common.model.*
import com.venmo.home.model.ITunesSearchResponse
import com.venmo.home.api.SearchRepository
import com.venmo.home.model.AlbumArtWork
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


    private val rawResults: LiveData<ApiResponse<ITunesSearchResponse>> = Transformations
        .switchMap(query) { search ->
            if (search.isNullOrBlank()) {
                AbsentLiveData.create()
            } else {
                searchRepository.search(search, country)
            }
        }

    val albumArtWorkSearchResults:LiveData<List<AlbumArtWork>> = Transformations
        .map(rawResults){
            when(it){
                is ApiSuccessResponse->{
                    it.body.toAlbumArtWork()
                }
                is ApiEmptyResponse -> emptyList()
                is ApiErrorResponse -> emptyList()
            }
        }



}

private fun ITunesSearchResponse.toAlbumArtWork(): List<AlbumArtWork>?{
   return this.results?.map {
        AlbumArtWork(it.artistName, it.trackName,it.collectionName )
    }

}
