package com.example.android.observability.demoTest;


public interface ImitateUserDataSource {

    ImitateUser getUser();

    void insertOrUpdateUser(ImitateUser imitateUser);

    void deleteAllUsers();
}
