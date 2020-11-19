package com.example.android.databinding.basicsample.imitate.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.android.databinding.basicsample.R
import com.example.android.databinding.basicsample.databinding.ActivityMainBinding

class ImitateMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.imitate_activity_main)
        binding.observableFieldsActivityButton.setOnClickListener {
            startActivity(Intent(this, ImitateObservableFieldActivity::class.java))
        }
        binding.viewmodelActivityButton.setOnClickListener {
            startActivity(Intent(this, ImitateViewModelActivity::class.java))
        }
    }
}