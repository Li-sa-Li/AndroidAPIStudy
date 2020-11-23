package com.example.android.databinding.basicsample.imitate.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableInt
import com.example.android.databinding.basicsample.R
import com.example.android.databinding.basicsample.databinding.ImitateObservableFieldProfileBinding
import com.example.android.databinding.basicsample.imitate.data.ImitateObservableFieldProfile

class ImitateObservableFieldActivity : AppCompatActivity() {
    // TODO: 2020/11/23  1,layout引用变量用@｛｝2，定义的变量需要在activity 赋值；3，click事件，需要加onlike（view:View）
    private val imitateObservableFieldProfile = ImitateObservableFieldProfile("ada", "lovelace", ObservableInt(0));
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bindingView: ImitateObservableFieldProfileBinding = DataBindingUtil.setContentView(this, R.layout.imitate_observable_field_profile)
        bindingView.use = imitateObservableFieldProfile;
    }

    fun onLikes(view: View) {
        imitateObservableFieldProfile.likes.set(imitateObservableFieldProfile.likes.get() + 1)
    }
}