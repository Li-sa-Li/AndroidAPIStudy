package com.example.googleappopenadtest

import android.app.Application
import android.util.Log
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener

class MyApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        MobileAds.initialize(this, OnInitializationCompleteListener {
            Log.i("MyApplication", "onCreate: ")
        })

        AppOpenManager(this);
    }
}