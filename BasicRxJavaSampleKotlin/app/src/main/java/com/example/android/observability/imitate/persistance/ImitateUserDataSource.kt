package com.example.android.observability.imitate.persistance

import io.reactivex.Completable
import io.reactivex.Flowable

interface ImitateUserDataSource {
    public fun getUser():Flowable<ImitateUser>
    public fun updateOrInsertUser(imitateuser:ImitateUser):Completable
}