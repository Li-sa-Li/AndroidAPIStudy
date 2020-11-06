package com.example.android.observability.demoTest;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.UUID;

@Entity(tableName = "Users")
public class ImitateUser {
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "userId")
    private String mId;

    @ColumnInfo(name = "userName")
    private String mUserName;

    public ImitateUser(String userName){
        mId = UUID.randomUUID().toString();
        mUserName = userName;
    }

    public ImitateUser(@NonNull String userId, String userName){
        mId = userId;
        mUserName = userName;
    }

    public String getId() {
        return mId;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setId(@NonNull String mId) {
        this.mId = mId;
    }

    public void setUserName(String mUserName) {
        this.mUserName = mUserName;
    }
}
