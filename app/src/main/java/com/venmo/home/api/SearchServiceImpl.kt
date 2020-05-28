package com.venmo.home.api

import com.venmo.home.model.ITunesSearchResponse
import retrofit2.Response
import javax.inject.Inject

class SearchServiceImpl @Inject constructor(private val searchApi: ISearchApi) : ISearchService {
    override suspend fun userData(
        searchTerm: String,
        country: String,
        startPosition: Int
    ): Response<ITunesSearchResponse> {

        return searchApi.userProfile(searchTerm, country, startPosition, 40)
    }
}