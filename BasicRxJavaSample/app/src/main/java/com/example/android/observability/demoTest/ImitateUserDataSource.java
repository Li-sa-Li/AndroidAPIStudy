package com.example.android.observability.demoTest;


import com.example.android.observability.demoTest.persisitence.ImitateUser;

import io.reactivex.Completable;
import io.reactivex.Flowable;

public interface ImitateUserDataSource {

    Flowable<ImitateUser> getUser();

    Completable insertOrUpdateUser(ImitateUser imitateUser);

    void deleteAllUsers();
}
