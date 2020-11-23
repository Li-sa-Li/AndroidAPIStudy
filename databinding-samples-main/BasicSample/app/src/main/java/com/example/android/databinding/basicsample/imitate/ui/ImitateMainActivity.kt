package com.example.android.databinding.basicsample.imitate.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.android.databinding.basicsample.R
import com.example.android.databinding.basicsample.databinding.ImitateActivityMainBinding

class ImitateMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding: ImitateActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.imitate_activity_main)
        binding.startObservableFieldsActivity.setOnClickListener {
            startActivity(Intent(this, ImitateObservableFieldActivity::class.java))
        }
        binding.startViewmodelActivity.setOnClickListener {
            startActivity(Intent(this, ImitateViewModelActivity::class.java))
        }
    }
}