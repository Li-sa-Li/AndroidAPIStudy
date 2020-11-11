package com.example.android.observability.demoTest;

import android.util.Log;

import androidx.lifecycle.ViewModel;

public class ImitateUserViewModel extends ViewModel {
    private ImitateUserDataSource mDataSource;

    public ImitateUserViewModel(ImitateUserDataSource dataSource) {
        mDataSource = dataSource;
    }

    public String getUserName() {
        Log.i("ImitateUserActivity", "getUserName: " + mDataSource.getUser().getUserName());
        return mDataSource.getUser().getUserName();
    }

    public void setUserName(String userName) {
        Log.i("ImitateUserActivity", "setUserName: " + userName);
        mDataSource.insertOrUpdateUser(new ImitateUser("1",userName));
    }
}
