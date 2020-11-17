package com.example.android.persistence.imitate

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.android.persistence.R

class ImitateMainActivity : AppCompatActivity(){
    // TODO: 2020/11/17 user common method to implement; then to compare;
    //  step one : a activity and two fragment;
    //  step two : use viewModel & LiveData & dataBinding & room database
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.imitate_activity_layout)
        var fragContainer = findViewById<FrameLayout>(R.id.fragment_container)

    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
