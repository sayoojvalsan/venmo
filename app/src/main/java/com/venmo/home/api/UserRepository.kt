//package com.venmo.home.api
//
//import androidx.lifecycle.LiveData
//import com.venmo.common.AppExecutors
//import com.venmo.common.model.ApiResponse
//import com.venmo.common.model.NetworkBoundResource
//import com.venmo.common.model.Resource
//import com.venmo.login.db.UserDataDao
//import com.venmo.login.model.UserData
//import javax.inject.Inject
//
//class UserRepository @Inject constructor(val appExecutors: AppExecutors, val userService: IUserService, val userDataDao: UserDataDao) {
//
//     fun getUserData(userId: String): LiveData<Resource<UserData>> {
//        return object : NetworkBoundResource<UserData, UserData>(appExecutors) {
//            override  fun saveCallResult(item: UserData) {
//                userDataDao.insertUserData(item)
//            }
//
//            override fun shouldFetch(data: UserData?): Boolean {
//                return true
//            }
//
//            override  fun loadFromDb(): LiveData<UserData> {
//                return userDataDao.getUserData()
//            }
//
//            override  fun createCall(): LiveData<ApiResponse<UserData>> {
//                return userService.userData(userId)
//            }
//        }.asLiveData()
//    }
//}