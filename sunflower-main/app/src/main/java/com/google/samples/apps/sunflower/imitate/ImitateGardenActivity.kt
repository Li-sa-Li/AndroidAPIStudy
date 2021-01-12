/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.samples.apps.sunflower.imitate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.google.samples.apps.sunflower.R

// TODO: 2020/12/28 1,两个页面显示数据，一个是花朵列表；一个是自己种养的花朵；2，详情页面；3，数据的存储；4，viewpager tab页
class ImitateGardenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("test00", "onCreateView: ")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imitate_garden)
        var leftTab = findViewById<Button>(R.id.left_tab)
        var rightTab = findViewById<Button>(R.id.right_tab)
        leftTab.setOnClickListener {
            var beginTransaction = supportFragmentManager.beginTransaction()
            beginTransaction.replace(R.id.container, LeftFragment(), "left frag")
            beginTransaction.commit()
        }
    }
}