package com.meeweel.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class DataModel : ViewModel() {

    val message1: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val message2: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val message3: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}