package com.example.android.observability.imitate.ui

import androidx.lifecycle.ViewModel
import com.example.android.observability.imitate.persistance.ImitateUser
import com.example.android.observability.imitate.persistance.ImitateUserDataSource
import io.reactivex.Completable
import io.reactivex.Flowable

class ImitateUserViewModel(imitateUserDataSource: ImitateUserDataSource) : ViewModel() {
    private var imitateUserDataSource: ImitateUserDataSource = imitateUserDataSource

    public fun setUserName(userName: String) :Completable{
        var imitateUser = ImitateUser("1",userName)
       return imitateUserDataSource.updateOrInsertUser(imitateUser)
    }

    public fun getUser(): Flowable<String> {
       return imitateUserDataSource.getUser().map {
           it.name
       }
    }

}