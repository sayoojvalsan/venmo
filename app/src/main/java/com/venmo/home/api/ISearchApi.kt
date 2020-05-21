package com.venmo.home.api

import androidx.lifecycle.LiveData
import com.venmo.common.model.ApiResponse
import com.venmo.home.model.ITunesSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ISearchApi {

    @GET("search")
    fun userProfile( @Query("term") text: String, @Query("country") country: String) : LiveData<ApiResponse<ITunesSearchResponse>>

}