package com.example.android.observability.demoTest;

import androidx.lifecycle.ViewModel;

public class ImitateUserViewModel extends ViewModel {
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
