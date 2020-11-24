package com.example.android.databinding.basicsample.imitate.data

import androidx.lifecycle.ViewModel

class ImitateProfileObservableViewModel(name: String, lastName: String) : ViewModel() {
    val name: String = name
    val lastName: String = lastName
}