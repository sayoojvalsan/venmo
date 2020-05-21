package com.venmo.home.api

import androidx.lifecycle.LiveData
import com.venmo.common.model.ApiResponse
import com.venmo.home.model.ITunesSearchResponse
import javax.inject.Inject

class SearchServiceImpl @Inject constructor(private val searchApi: ISearchApi) : ISearchService {
    override  fun userData(searchTerm: String, country : String): LiveData<ApiResponse<ITunesSearchResponse>> {
        return searchApi.userProfile(searchTerm, country)
    }
}



//@Singleton
//class SearchServiceImpl @Inject constructor(private val searchApi: ISearchApi) : ISearchService {
//    override fun userData(searchTerm: String, country : String): LiveData<ApiResponse<ITunesSearchResponse>> {
//        return searchApi.userProfile(searchTerm, country)
//    }
//}
