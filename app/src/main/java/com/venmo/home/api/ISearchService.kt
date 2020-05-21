package com.venmo.home.api

import androidx.lifecycle.LiveData
import com.venmo.common.model.ApiResponse
import com.venmo.home.model.ITunesSearchResponse


interface ISearchService{
      suspend fun userData(searchTerm: String, country : String
    ): LiveData<ApiResponse<ITunesSearchResponse>>
}