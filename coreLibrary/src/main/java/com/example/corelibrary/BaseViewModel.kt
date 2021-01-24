package com.example.corelibrary

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel<T> : ViewModel() {

    fun viewState(): LiveData<T> = viewState
    protected val viewState: MutableLiveData<T> = MutableLiveData()
}
