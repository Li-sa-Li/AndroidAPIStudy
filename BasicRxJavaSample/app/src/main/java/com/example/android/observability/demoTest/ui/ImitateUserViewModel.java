package com.example.android.observability.demoTest.ui;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.example.android.observability.demoTest.ImitateUserDataSource;
import com.example.android.observability.demoTest.persisitence.ImitateUser;

import io.reactivex.Completable;
import io.reactivex.Flowable;

public class ImitateUserViewModel extends ViewModel {
    private ImitateUserDataSource mDataSource;
    private ImitateUser mImitateUser;

    public ImitateUserViewModel(ImitateUserDataSource dataSource) {
        mDataSource = dataSource;
    }

    public Flowable<String> getUserName() {
        return mDataSource.getUser().map(imitateUser -> {
            mImitateUser = imitateUser;
            return imitateUser.getUserName();
        });
    }

   public Completable setUserName(String userName) {
//        Log.i("ImitateUserActivity", "setUserName: " + userName);
        mImitateUser = mImitateUser == null ? new ImitateUser(userName) : new ImitateUser(mImitateUser.getId(), userName);
        return mDataSource.insertOrUpdateUser(mImitateUser);
    }
}
