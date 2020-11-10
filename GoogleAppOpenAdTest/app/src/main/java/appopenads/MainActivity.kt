package com.lazygeniouz.appopenads

import android.app.Activity
import android.os.Bundle
import com.example.googleappopenadtest.R
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.RequestConfiguration
import java.util.*

/** Sample App's Main Activity */
class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        var configuration = RequestConfiguration.Builder()
            .setTestDeviceIds(Arrays.asList("4C57E028DAF3CAB2997632B754DC2C79")).build()
        MobileAds.setRequestConfiguration(configuration)
    }
}