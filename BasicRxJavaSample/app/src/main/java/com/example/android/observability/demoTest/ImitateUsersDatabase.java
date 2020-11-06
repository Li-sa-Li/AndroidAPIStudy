package com.example.android.observability.demoTest;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {ImitateUser.class}, version = 1,exportSchema = false)
public abstract class ImitateUsersDatabase extends RoomDatabase {

    private static ImitateUsersDatabase INSTANCE;

    abstract ImitateUserDao imitateUserDao();

    public static ImitateUsersDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (ImitateUsersDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, ImitateUsersDatabase.class
                            , "ImitateSample.db")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
