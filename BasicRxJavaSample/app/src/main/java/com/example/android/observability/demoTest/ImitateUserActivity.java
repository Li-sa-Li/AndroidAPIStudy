package com.example.android.observability.demoTest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.android.persistence.R;

public class ImitateUserActivity extends AppCompatActivity {
    private static final String TAG = ImitateUserActivity.class.getSimpleName();
    private TextView mUserName;
    private EditText mUserNameInput;
    private Button mUpdateUser;
    private ImitateUserViewModel mUserViewModel;

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
        mUserViewModel = new ImitateViewModelFactory().create(ImitateUserViewModel.class);
        Log.i(TAG, "onCreate: " + mUserViewModel + ":userName:" + mUserViewModel.getUserName());
        mUserViewModel.setUserName(mUserNameInput.getText().toString());

        mUpdateUser.setOnClickListener(v -> updateUserName());
    }

    private void updateUserName() {
        final String text = mUserNameInput.getText().toString();
        mUserViewModel.setUserName(text);
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
        Log.i(TAG, "onRestart: " + (mUserViewModel == null ? null : mUserViewModel.getUserName()));
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: " + (mUserViewModel == null ? null : mUserViewModel.getUserName()));
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop mUserViewModel: " + (mUserViewModel == null ? null : mUserViewModel.getUserName()));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy mUserViewModel: " + (mUserViewModel.getUserName()));
    }

    @Override
    protected void onResume() {
        Log.i(TAG, "onResume: " + (mUserViewModel == null ? null : mUserViewModel.getUserName()));
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: " + (mUserViewModel == null ? null : mUserViewModel.getUserName()));
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