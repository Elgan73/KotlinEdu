package com.stark.kotlinedu.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.stark.kotlinedu.model.Repository

class MainViewModel : ViewModel() {
    private val viewStateLiveData = MutableLiveData<MainViewState>()

    init {
        viewStateLiveData.value =
            MainViewState(Repository.noteList)
    }

    fun getViewState(): LiveData<MainViewState> = viewStateLiveData
}