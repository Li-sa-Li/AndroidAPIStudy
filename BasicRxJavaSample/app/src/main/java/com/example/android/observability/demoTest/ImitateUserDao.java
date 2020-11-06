package com.example.android.observability.demoTest;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.android.observability.persistence.User;

import java.util.List;

@Dao
public interface ImitateUserDao {
    @Query("SELECT * FROM users LIMIT 1")
    ImitateUser getImitateUser();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertImitateUser(ImitateUser user);

    @Query("DELETE FROM Users")
    void deleteAllImitateUser();
}
