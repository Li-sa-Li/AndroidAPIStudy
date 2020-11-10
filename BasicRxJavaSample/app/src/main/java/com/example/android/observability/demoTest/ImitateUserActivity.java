package com.example.android.observability.demoTest;


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

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

import io.reactivex.Flowable;
import io.reactivex.internal.util.BlockingIgnoringReceiver;

public class ImitateUserActivity extends AppCompatActivity {
    private static final String TAG = ImitateUserActivity.class.getSimpleName();
    private TextView mUserName;
    private EditText mUserNameInput;
    private Button mUpdateUser;
    private ImitateUserViewModel mUserViewModel;
    private ScheduledExecutorService mThreadPool;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what){
                case 1:
                    if (mUserName != null) {
                        mUserName.setText(((String) msg.obj));
                    }
                    break;
            }
        }
    };

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
        ViewModelProvider viewModelProvider = new ViewModelProvider(this,new ImitateViewModelFactory(this));
        mUserViewModel = viewModelProvider.get(ImitateUserViewModel.class);
        Log.i(TAG, "onCreate: " + mUserViewModel);
        mUpdateUser.setOnClickListener(v -> updateUserName());
        mThreadPool = Executors.newScheduledThreadPool(3);
    }

    private void updateUserName() {

        Flowable

        final String text = mUserNameInput.getText().toString();
        mThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                Log.i(TAG, "run: "+text);
                mUserViewModel.setUserName(text);
            }
        });
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
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
        mThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                Log.i(TAG, "username==="+mUserViewModel.getUserName());
                Message message = new Message();
                message.what =1;
                message.obj = mUserViewModel.getUserName();
                handler.sendMessage(message);
            }
        });
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