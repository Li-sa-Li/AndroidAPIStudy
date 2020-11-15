package com.example.android.observability.imitate.ui

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import com.example.android.observability.R
import com.example.android.observability.imitate.ImitateInjection
import com.example.android.observability.imitate.persistance.ImitateLocalDataSource
import com.example.android.observability.imitate.persistance.ImitateUserDataBase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class ImitateUserActivity : AppCompatActivity() {

    val compositeDisposable: CompositeDisposable = CompositeDisposable()
    private lateinit var providerFactory: ImitateViewModelFactory

    private val imitateUserViewModel: ImitateUserViewModel by viewModels { providerFactory }

    lateinit var userNameInput: EditText;
    lateinit var userName: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        userName = findViewById<TextView>(R.id.user_name)
        userNameInput = findViewById<EditText>(R.id.user_name_input)
        var updateUserButton = findViewById<Button>(R.id.update_user_button)

        providerFactory = ImitateInjection.providerFactory(this)

        updateUserButton.setOnClickListener {
            updateUserName()
        }
    }

    private fun updateUserName() {
        userName.text = userNameInput.text.toString()
        compositeDisposable.add(
                imitateUserViewModel.setUserName(userNameInput.text.toString())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.newThread())
                        .subscribe { Log.d("act", "updateUserName: ") }
        )

    }

    override fun onStart() {
        super.onStart()
        compositeDisposable.add(imitateUserViewModel.getUser().observeOn(Schedulers.newThread())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    Log.d("act", "onStart: " + it)
                    userName.text = it
                })
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }
}
