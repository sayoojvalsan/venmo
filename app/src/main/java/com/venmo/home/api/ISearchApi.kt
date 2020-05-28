package com.venmo.home.api

import com.venmo.home.model.ITunesSearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ISearchApi {

    @GET("search")
    suspend fun userProfile(
        @Query("term") text: String,
        @Query("country") country: String,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ) : Response<ITunesSearchResponse>

}