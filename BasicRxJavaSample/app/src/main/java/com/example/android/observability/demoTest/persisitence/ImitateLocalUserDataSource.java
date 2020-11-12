package com.example.android.observability.demoTest.persisitence;

import com.example.android.observability.demoTest.ImitateUserDataSource;
import com.example.android.observability.demoTest.persisitence.ImitateUser;
import com.example.android.observability.demoTest.persisitence.ImitateUserDao;

import io.reactivex.Completable;
import io.reactivex.Flowable;

public class ImitateLocalUserDataSource implements ImitateUserDataSource {
    private ImitateUserDao mUserDao;

    public ImitateLocalUserDataSource(ImitateUserDao imitateUserDao) {
        mUserDao = imitateUserDao;
    }

    @Override
    public Flowable<ImitateUser> getUser() {
       return mUserDao.getImitateUser();
    }

    @Override
    public Completable insertOrUpdateUser(ImitateUser imitateUser) {
        return mUserDao.insertImitateUser(imitateUser);
    }

    @Override
    public void deleteAllUsers() {
        mUserDao.deleteAllImitateUser();
    }
}
