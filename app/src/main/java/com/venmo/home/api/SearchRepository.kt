package com.venmo.home.api

import com.venmo.home.model.ITunesSearchResponse
import retrofit2.Response
import javax.inject.Inject

class SearchRepository @Inject constructor(private val searchService: ISearchService) {

       suspend fun search(searchText: String, country: String): Response<ITunesSearchResponse> {
           return searchService.userData(searchText, country)
//           return if (userDataResponse.code() == 200) {
//               userDataResponse.body()
//           }
//           else{
//               null
//           }

       }


}