package com.example.android.observability.demoTest;

import android.content.Context;

public class ImitateInjection {

    public static ImitateViewModelFactory provideImitateViewModelFactory(Context context) {
        return new ImitateViewModelFactory(provideLocalUserDataSource(context));
    }

    private static LocalUserDataSource provideLocalUserDataSource(Context context) {
        final ImitateUsersDatabase usersDatabase = ImitateUsersDatabase.getInstance(context);
        return new LocalUserDataSource(usersDatabase.imitateUserDao());
    }
}
