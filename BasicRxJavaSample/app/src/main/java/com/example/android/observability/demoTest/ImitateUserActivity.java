package com.example.android.observability.demoTest;


import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.android.persistence.R;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class ImitateUserActivity extends AppCompatActivity {
    private static final String TAG = ImitateUserActivity.class.getSimpleName();
    private TextView mUserName;
    private EditText mUserNameInput;
    private Button mUpdateUser;
    private ImitateUserViewModel mUserViewModel;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate: ");
        setContentView(R.layout.activity_imitate_user);
        mUserName = (TextView) findViewById(R.id.user_name);
        mUserNameInput = (EditText) findViewById(R.id.user_name_input);
        mUpdateUser = (Button) findViewById(R.id.update_user);
        String userName = null;
        if (savedInstanceState != null) {
            userName = (String) savedInstanceState.get("user_name");
        }
        final ImitateViewModelFactory imitateViewModelFactory = ImitateInjection.provideImitateViewModelFactory(this);
        ViewModelProvider viewModelProvider = new ViewModelProvider(this, imitateViewModelFactory);
        mUserViewModel = viewModelProvider.get(ImitateUserViewModel.class);
        Log.i(TAG, "onCreate: " + mUserViewModel);
        mUpdateUser.setOnClickListener(v -> updateUserName());
    }

    private void updateUserName() {

        final String text = mUserNameInput.getText().toString();
        compositeDisposable.add(mUserViewModel.setUserName(text)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> mUpdateUser.setEnabled(false), throwable -> Log.i(TAG, "Unable to update user name ", throwable)));
        if (!TextUtils.isEmpty(text)) {
            mUserName.setText(text);
        }
    }

//    @Override
//    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        final String userName = savedInstanceState.getString("user_name");
//        Log.i(TAG, "onRestoreInstanceState: "+userName);
//            if (!TextUtils.isEmpty(userName)) {
//                mUserName.setText(userName);
//            }
//    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
        if (compositeDisposable != null) {
            compositeDisposable.clear();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
        compositeDisposable.add(mUserViewModel.getUserName()
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> mUserName.setText(s), throwable -> Log.i(TAG, "Unable to get user name ", throwable)));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ");
    }

//    @Override
//    protected void onSaveInstanceState(@NonNull Bundle outState) {
//        super.onSaveInstanceState(outState);
//        Log.i(TAG, "onSaveInstanceState one: ");
//        outState.putString("user_name",mUserNameInput.getText().toString());
//    }
//
//    @Override
//    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
//        super.onSaveInstanceState(outState, outPersistentState);
//        Log.i(TAG, "onSaveInstanceState two: ");
//        outState.putString("user_name",mUserNameInput.getText().toString());
//    }
}