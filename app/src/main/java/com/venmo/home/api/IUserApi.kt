//package com.venmo.home.api
//
//import androidx.lifecycle.LiveData
//import com.venmo.common.model.ApiResponse
//import com.venmo.login.model.UserData
//import retrofit2.http.GET
//import retrofit2.http.Path
//
//interface IUserApi {
//
//    @GET("api/v11/user/{userId}/profile")
//    fun userProfile( @Path("userId") userId: String) : LiveData<ApiResponse<UserData>>
//
//
//}