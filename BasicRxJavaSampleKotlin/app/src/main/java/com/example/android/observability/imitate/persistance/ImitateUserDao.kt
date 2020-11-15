package com.example.android.observability.imitate.persistance

import androidx.room.*
import com.google.android.material.circularreveal.CircularRevealHelper
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface ImitateUserDao {

    @Query("SELECT * FROM users LIMIT 1")
    fun getUser():Flowable<ImitateUser>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun updateOrInsertUser(user: ImitateUser):Completable

    @Query("DELETE  FROM users")
    fun delAllImitateUser()
}