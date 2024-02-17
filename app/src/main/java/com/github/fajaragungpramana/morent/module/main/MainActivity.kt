package com.github.fajaragungpramana.morent.module.main

import android.os.Bundle
import com.github.fajaragungpramana.morent.common.app.AppActivity
import com.github.fajaragungpramana.morent.databinding.ActivityMainBinding

class MainActivity : AppActivity<ActivityMainBinding>() {

    override fun onViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

    override fun onCreated(savedInstanceState: Bundle?) {

    }

}