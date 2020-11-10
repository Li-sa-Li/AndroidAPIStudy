package com.example.googleappopenadtest

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ProcessLifecycleOwner
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.appopen.AppOpenAd
import com.google.android.gms.ads.appopen.AppOpenAd.AppOpenAdLoadCallback
import java.util.*

class AppOpenManager(myApplication: MyApplication) : Application.ActivityLifecycleCallbacks,
    LifecycleObserver {
    private var appOpenAd: AppOpenAd? = null
    private val TAG: String = "AppOpenManager";
    private val AD_UNIT_ID: String = "ca-app-pub-3940256099942544/3419835294"
    private lateinit var loadCallback: AppOpenAdLoadCallback
    private var currentActivity: Activity? = null
    private var myApplication:MyApplication = myApplication
    private var isShowingAd:Boolean = false
    private var loadTime:Long =0
    init {
        myApplication.registerActivityLifecycleCallbacks(this)
        ProcessLifecycleOwner.get().lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart(){
        Log.d(TAG, "onStart: ")
    }

    fun fetchAd() {
        if (isAdAvailable()) {
            return;
        }
        loadCallback = object : AppOpenAdLoadCallback() {

            override fun onAppOpenAdFailedToLoad(p0: LoadAdError?) {
                super.onAppOpenAdFailedToLoad(p0)
                Log.d(TAG, "onAppOpenAdFailedToLoad: " + p0?.message)
            }

            override fun onAppOpenAdFailedToLoad(p0: Int) {
                super.onAppOpenAdFailedToLoad(p0)
            }

            override fun onAppOpenAdLoaded(p0: AppOpenAd?) {
                super.onAppOpenAdLoaded(p0)
                appOpenAd = p0
                loadTime = Date().time
            }
        }
        var adRequest = getAdRequest()
        AppOpenAd.load(
            myApplication,
            AD_UNIT_ID,
            adRequest,
            AppOpenAd.APP_OPEN_AD_ORIENTATION_PORTRAIT,
            loadCallback
        )
    }

    private fun getAdRequest(): AdRequest {
        return AdRequest.Builder().build();
    }

    fun isAdAvailable(): Boolean {
        return appOpenAd != null&&wasLoadTimeLessThanNHoursAgo(4)
    }
    fun wasLoadTimeLessThanNHoursAgo(numHours:Long):Boolean{
        var dateDifference = Date().time - loadTime
        var numMilliSecondPerHour = 3600000;
        return dateDifference<(numMilliSecondPerHour*numHours)
    }
    fun showAdIfAvailable(){
        if(!isShowingAd && isAdAvailable()){
            Log.d(TAG, "showAdIfAvailable: ")
        val fullScreenContentCallback:FullScreenContentCallback =   object :FullScreenContentCallback(){
               override fun onAdDismissedFullScreenContent() {
                   super.onAdDismissedFullScreenContent()
                   Log.d(TAG, "onAdDismissedFullScreenContent: ")
               }

               override fun onAdFailedToShowFullScreenContent(p0: AdError?) {
                   super.onAdFailedToShowFullScreenContent(p0)
                   Log.d(TAG, "onAdFailedToShowFullScreenContent: "+p0?.message)
               }

               override fun onAdShowedFullScreenContent() {
                   super.onAdShowedFullScreenContent()
                   isShowingAd = true
                   Log.d(TAG, "onAdShowedFullScreenContent: ")
               }
            }
            appOpenAd?.show(currentActivity,fullScreenContentCallback)
        }else{
            Log.d(TAG, "showAdIfAvailable: ")
            fetchAd()
        }
    }

    override fun onActivityPaused(p0: Activity) {
        Log.i(TAG, "onActivityPaused: ")
    }

    override fun onActivityStarted(p0: Activity) {
        Log.i(TAG, "onActivityStarted: ")
        currentActivity = p0
    }

    override fun onActivityDestroyed(p0: Activity) {
        Log.i(TAG, "onActivityDestroyed: ")
        currentActivity = null
    }

    override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) {
        Log.i(TAG, "onActivitySaveInstanceState: ")
    }

    override fun onActivityStopped(p0: Activity) {
        Log.i(TAG, "onActivityStopped: ")
    }

    override fun onActivityCreated(p0: Activity, p1: Bundle?) {
        Log.i(TAG, "onActivityCreated: ")
    }

    override fun onActivityResumed(p0: Activity) {
        Log.i(TAG, "onActivityResumed: ")
        currentActivity = p0
    }
}