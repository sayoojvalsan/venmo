package com.venmo.home.ui

import androidx.lifecycle.*
import com.venmo.common.model.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor() : ViewModel() {

    private val _userID: MutableLiveData<String> = MutableLiveData()

//    val user: LiveData<Resource<UserData>> = Transformations
//        .switchMap(_userID) { userID ->
//            if (userID == null) {
//                AbsentLiveData.create()
//            } else {
//                userRepository.getUserData(userID)
//            }
//        }


    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text


//
//    init {
//        viewModelScope.launch(Dispatchers.IO){
//            val userId = sessionRepo.getUserSession()?.userId
//            _userID.postValue(userId)
//        }
//    }
}