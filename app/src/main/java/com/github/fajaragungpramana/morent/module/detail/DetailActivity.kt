package com.github.fajaragungpramana.morent.module.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.fajaragungpramana.morent.common.app.AppActivity
import com.github.fajaragungpramana.morent.common.contract.AppState
import com.github.fajaragungpramana.morent.core.domain.house.model.House
import com.github.fajaragungpramana.morent.databinding.ActivityDetailBinding
import com.github.fajaragungpramana.morent.module.adapter.ImageAdapter
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailActivity : AppActivity<ActivityDetailBinding>(), AppState {

    private val viewModel: DetailViewModel by viewModels()

    private lateinit var imageAdapter: ImageAdapter

    override fun onViewBinding(): ActivityDetailBinding =
        ActivityDetailBinding.inflate(layoutInflater)

    override fun onCreated(savedInstanceState: Bundle?) {
        initView()
        initClick()
        initHouseImage()

        val id = intent.getIntExtra("id", 1)
        viewModel.setEvent(DetailEvent.House(id))
    }

    override fun onStateObserver() {
        lifecycleScope.launch {
            viewModel.state.collectLatest {
                when (it) {
                    is DetailState.HouseData -> setHouse(it.house)
                    is DetailState.MessageData ->
                        Snackbar.make(viewBinding.root, it.message.orEmpty(), Snackbar.LENGTH_LONG)
                            .show()
                }
            }
        }
    }

    private fun initView() {
        setSupportActionBar(viewBinding.mtlDetail)
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setDisplayShowTitleEnabled(false)
        }
    }

    private fun initClick() {
        viewBinding.mtlDetail.setNavigationOnClickListener { finish() }
    }

    private fun initHouseImage() {
        imageAdapter = ImageAdapter()
        viewBinding.apply {
            rvHouseImage.layoutManager =
                LinearLayoutManager(this@DetailActivity, RecyclerView.HORIZONTAL, false)
            rvHouseImage.adapter = imageAdapter
        }
    }

    private fun setHouse(house: House) {
        imageAdapter.submitList(house.listImage)

        viewBinding.apply {
            mtvHouseName.text = house.title
            mtvHouseAddress.text = house.address
            mtvHousePrice.text = house.price
            mtvHouseOverview.text = house.overview
        }
    }

}