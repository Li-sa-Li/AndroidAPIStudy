package com.example.android.databinding.basicsample.imitate.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.android.databinding.basicsample.R
import com.example.android.databinding.basicsample.databinding.ImitateViewmodelProfileBinding
import com.example.android.databinding.basicsample.imitate.data.ImitateProfileObservableViewModel

class ImitateViewModelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var contentView: ImitateViewmodelProfileBinding = DataBindingUtil.setContentView(this, R.layout.imitate_viewmodel_profile)
        contentView.viewModel = ImitateProfileObservableViewModel("li", "lisa")
    }

    fun onLikeClick(view: View){

    }
}