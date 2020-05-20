package com.venmo.utils



class Looper {
    companion object
}

fun Looper.Companion.isMainThread() : Boolean{
return android.os.Looper.getMainLooper() == android.os.Looper.myLooper()
}