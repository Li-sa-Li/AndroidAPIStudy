package com.example.android.observability.demoTest;

import android.content.Context;

public class LocalUserDataSource implements ImitateUserDataSource {
    private ImitateUserDao mUserDao;

    public LocalUserDataSource(ImitateUserDao imitateUserDao) {
        mUserDao = imitateUserDao;
    }

    @Override
    public ImitateUser getUser() {
        return mUserDao.getImitateUser();
    }

    @Override
    public void insertOrUpdateUser(ImitateUser imitateUser) {
        mUserDao.insertImitateUser(imitateUser);
    }

    @Override
    public void deleteAllUsers() {
        mUserDao.deleteAllImitateUser();
    }
}
