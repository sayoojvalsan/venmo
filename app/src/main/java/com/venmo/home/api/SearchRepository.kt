package com.venmo.home.api

import androidx.lifecycle.LiveData
import com.venmo.common.model.ApiResponse
import com.venmo.home.model.ITunesSearchResponse
import javax.inject.Inject

class SearchRepository @Inject constructor(private val searchService: ISearchService) {

      suspend fun search(searchText: String, country: String): LiveData<ApiResponse<ITunesSearchResponse>> {
         return searchService.userData(searchText, country)
    }


}