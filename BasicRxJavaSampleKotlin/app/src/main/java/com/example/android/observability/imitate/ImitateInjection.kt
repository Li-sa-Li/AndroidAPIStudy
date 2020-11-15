package com.example.android.observability.imitate

import android.content.Context
import com.example.android.observability.imitate.persistance.ImitateLocalDataSource
import com.example.android.observability.imitate.persistance.ImitateUserDataBase
import com.example.android.observability.imitate.ui.ImitateViewModelFactory

class ImitateInjection(){

    companion object{
        public fun providerFactory(context: Context):ImitateViewModelFactory{
            return ImitateViewModelFactory(providerUserData(context))
        }
        private fun providerUserData(context: Context):ImitateLocalDataSource{
            return ImitateLocalDataSource(ImitateUserDataBase.getInstance(context))
        }
    }
}