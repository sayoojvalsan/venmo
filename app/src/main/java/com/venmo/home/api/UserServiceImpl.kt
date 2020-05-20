//package com.venmo.home.api
//
//import androidx.lifecycle.LiveData
//import com.venmo.common.model.ApiResponse
//import com.venmo.login.model.UserData
//import javax.inject.Inject
//class UserServiceImpl @Inject constructor(private val userApi: IUserApi) : IUserService {
//        override  fun userData(profileID: String): LiveData<ApiResponse<UserData>> {
//        return userApi.userProfile(profileID)
//    }
//}
