package com.github.fajaragungpramana.morent.module.main

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import coil.transform.CircleCropTransformation
import com.github.fajaragungpramana.morent.common.app.AppActivity
import com.github.fajaragungpramana.morent.common.contract.AppState
import com.github.fajaragungpramana.morent.core.domain.user.model.User
import com.github.fajaragungpramana.morent.databinding.ActivityMainBinding
import com.github.fajaragungpramana.morent.module.adapter.HouseAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppActivity<ActivityMainBinding>(), AppState {

    private val viewModel: MainViewModel by viewModels()

    private lateinit var houseAdapter: HouseAdapter

    override fun onViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

    override fun onCreated(savedInstanceState: Bundle?) {
        initHouse()

        viewModel.setEvent(MainEvent.USER)
        viewModel.setEvent(MainEvent.LIST_HOUSE)
    }

    override fun onStateObserver() {
        lifecycleScope.launch {
            viewModel.state.collectLatest {
                when (it) {
                    is MainState.UserData -> setUserView(it.user)
                    is MainState.HouseData -> houseAdapter.submitList(it.listHouse)

                    is MainState.MessageData -> Log.d("FFFF", "")
                }
            }
        }
    }

    private fun initHouse() {
        houseAdapter = HouseAdapter()
        viewBinding.apply {
            rvHouse.layoutManager = LinearLayoutManager(this@MainActivity)
            rvHouse.adapter = houseAdapter
        }
    }

    private fun setUserView(user: User) {
        viewBinding.apply {
            aivUserAvatar.load(user.avatar) {
                transformations(CircleCropTransformation())
            }
            mtvUserName.text = user.name
        }
    }

}