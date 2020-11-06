package com.example.android.observability.demoTest;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.android.persistence.R;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ImitateUserActivity extends AppCompatActivity {
    private static final String TAG = ImitateUserActivity.class.getSimpleName();
    private TextView mUserName;
    private EditText mUserNameInput;
    private Button mUpdateUser;
    private ImitateUserViewModel mUserViewModel;
    private ScheduledExecutorService mThreadPool;


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
        mUserViewModel = new ImitateViewModelFactory(this).create(ImitateUserViewModel.class);
        Log.i(TAG, "onCreate: " + mUserViewModel + ":userName:" + null);
        mUpdateUser.setOnClickListener(v -> updateUserName());
        mThreadPool = Executors.newScheduledThreadPool(3, null);
        mThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                Log.i(TAG, mUserViewModel.getUserName());
            }
        });
    }

    private void updateUserName() {
        final String text = mUserNameInput.getText().toString();
        mThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                mUserViewModel.setUserName(text);
            }
        });
        if (!TextUtils.isEmpty(text)) {
            mUserName.setText(text);
            mUserViewModel.setUserName(text);
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
        Log.i(TAG, "onRestart: " + (mUserViewModel == null ? null : null));
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: " + (mUserViewModel == null ? null : null));
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop mUserViewModel: " + (mUserViewModel == null ? null : null));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy mUserViewModel: " + (null));
    }

    @Override
    protected void onResume() {
        Log.i(TAG, "onResume: " + (mUserViewModel == null ? null : null));
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: " + (mUserViewModel == null ? null : null));
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