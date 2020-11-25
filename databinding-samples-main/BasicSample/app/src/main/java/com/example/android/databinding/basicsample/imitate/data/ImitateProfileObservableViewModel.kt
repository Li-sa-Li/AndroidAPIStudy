package com.example.android.databinding.basicsample.imitate.data

import androidx.databinding.ObservableInt
import androidx.lifecycle.ViewModel

class ImitateProfileObservableViewModel(name: String, lastName: String) : ViewModel() {
    val name: String = name
    val lastName: String = lastName
    var likes:ObservableInt = ObservableInt()

    fun onLikes(){
        likes.set(likes.get()+1)
    }
}