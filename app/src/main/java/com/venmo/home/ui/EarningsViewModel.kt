package com.venmo.home.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EarningsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Earnings Fragment"
    }
    val text: LiveData<String> = _text
}