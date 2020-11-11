package com.example.android.observability.demoTest;

import io.reactivex.Completable;
import io.reactivex.Flowable;

public class LocalUserDataSource implements ImitateUserDataSource {
    private ImitateUserDao mUserDao;

    public LocalUserDataSource(ImitateUserDao imitateUserDao) {
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
