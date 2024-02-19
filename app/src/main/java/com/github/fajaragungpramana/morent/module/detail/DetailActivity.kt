package com.github.fajaragungpramana.morent.module.detail

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.fajaragungpramana.morent.R
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
    private lateinit var house: House

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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_share -> shareHouse(house)
        }
        return super.onOptionsItemSelected(item)
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
        this.house = house

        imageAdapter.submitList(house.listImage)

        viewBinding.apply {
            mtvHouseName.text = house.title
            mtvHouseAddress.text = house.address
            mtvHousePrice.text = house.price
            mtvHouseOverview.text = house.overview
        }
    }

    private fun shareHouse(house: House) {
        try {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_SUBJECT, house.title)
            intent.putExtra(Intent.EXTRA_TEXT, "https://rumah123.com/")
            startActivity(intent)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}