package com.venmo.home.api

import com.venmo.home.model.ITunesSearchResponse
import retrofit2.Response


interface ISearchService{
      suspend fun userData(
          searchTerm: String, country: String, startPosition: Int
      ): Response<ITunesSearchResponse>
}