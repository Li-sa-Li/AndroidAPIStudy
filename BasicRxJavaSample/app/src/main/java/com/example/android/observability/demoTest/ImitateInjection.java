package com.example.android.observability.demoTest;

import android.content.Context;

import com.example.android.observability.demoTest.persisitence.ImitateUsersDatabase;
import com.example.android.observability.demoTest.persisitence.ImitateLocalUserDataSource;
import com.example.android.observability.demoTest.ui.ImitateViewModelFactory;

public class ImitateInjection {

    public static ImitateViewModelFactory provideImitateViewModelFactory(Context context) {
        return new ImitateViewModelFactory(provideLocalUserDataSource(context));
    }

    public static ImitateLocalUserDataSource provideLocalUserDataSource(Context context) {
        final ImitateUsersDatabase usersDatabase = ImitateUsersDatabase.getInstance(context);
        return new ImitateLocalUserDataSource(usersDatabase.imitateUserDao());
    }
}
