package com.example.android.observability.imitate.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.observability.imitate.persistance.ImitateLocalDataSource

class ImitateViewModelFactory(val dataSource: ImitateLocalDataSource) : ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ImitateUserViewModel::class.java)) {
            return ImitateUserViewModel(dataSource) as T
        }
        throw IllegalAccessException("unKnown viewmodel class")
    }
}