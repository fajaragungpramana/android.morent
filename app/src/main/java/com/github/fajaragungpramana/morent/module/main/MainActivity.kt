package com.github.fajaragungpramana.morent.module.main

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.github.fajaragungpramana.morent.common.app.AppActivity
import com.github.fajaragungpramana.morent.common.contract.AppState
import com.github.fajaragungpramana.morent.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppActivity<ActivityMainBinding>(), AppState {

    private val viewModel: MainViewModel by viewModels()

    override fun onViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

    override fun onCreated(savedInstanceState: Bundle?) {
        viewModel.setEvent(MainEvent.USER)
    }

    override fun onStateObserver() {
        lifecycleScope.launch {
            viewModel.state.collectLatest {
                when (it) {
                    is MainState.UserData -> Log.d("FFFF", "${it.user}")
                    is MainState.MessageData -> Log.d("FFFF", "")
                }
            }
        }
    }

}