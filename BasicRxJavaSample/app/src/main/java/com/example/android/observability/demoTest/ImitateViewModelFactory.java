package com.example.android.observability.demoTest;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.android.observability.UserDataSource;
import com.example.android.observability.persistence.User;
import com.example.android.observability.ui.UserViewModel;

import io.reactivex.Completable;
import io.reactivex.Flowable;

public class ImitateViewModelFactory implements ViewModelProvider.Factory {
    /**
     * ；泛型好用：可以灵活扩展
     * @param modelClass
     * @param <T>
     * @return
     */
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(ImitateUserViewModel.class)) {
            return (T) new ImitateUserViewModel();
        }else if(modelClass.isAssignableFrom(UserViewModel.class)){
//            return (T) new UserViewModel()
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
