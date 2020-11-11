package com.example.android.observability.demoTest;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import io.reactivex.Completable;
import io.reactivex.Flowable;

@Dao
public interface ImitateUserDao {
    @Query("SELECT * FROM users LIMIT 1")
    Flowable<ImitateUser> getImitateUser();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertImitateUser(ImitateUser user);

    @Query("DELETE FROM Users")
    void deleteAllImitateUser();
}
