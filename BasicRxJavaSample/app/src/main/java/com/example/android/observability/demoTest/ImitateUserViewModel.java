package com.example.android.observability.demoTest;

import android.util.Log;

import androidx.lifecycle.ViewModel;

public class ImitateUserViewModel extends ViewModel {
    private ImitateUsersDatabase mDatabase;
    public ImitateUserViewModel(ImitateUsersDatabase dataSource){
        mDatabase = dataSource;
    }

    public String getUserName() {
        final ImitateUser imitateUser = mDatabase.imitateUserDao().getImitateUser();
        return imitateUser.getUserName();
    }

    public void setUserName(String userName) {
        Log.i("ImitateUserActivity", "setUserName: "+userName);
        mDatabase.imitateUserDao().insertImitateUser(new ImitateUser(userName));
    }
}
