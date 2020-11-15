package com.example.android.observability.imitate.persistance

import io.reactivex.Completable
import io.reactivex.Flowable

class ImitateLocalDataSource(dataBase: ImitateUserDataBase) : ImitateUserDataSource {

    private var dataBase:ImitateUserDataBase = dataBase

    override fun updateOrInsertUser(imitateuser:ImitateUser):Completable {
        return dataBase.initImitateUserDao().updateOrInsertUser(imitateuser)
    }

    override fun getUser():Flowable<ImitateUser> {
      return dataBase.initImitateUserDao().getUser()
    }
}