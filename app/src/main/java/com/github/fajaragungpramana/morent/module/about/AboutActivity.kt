package com.github.fajaragungpramana.morent.module.about

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import coil.load
import coil.transform.CircleCropTransformation
import com.github.fajaragungpramana.morent.common.app.AppActivity
import com.github.fajaragungpramana.morent.common.contract.AppState
import com.github.fajaragungpramana.morent.core.domain.user.model.User
import com.github.fajaragungpramana.morent.databinding.ActivityAboutBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AboutActivity : AppActivity<ActivityAboutBinding>(), AppState {

    private val viewModel: AboutViewModel by viewModels()

    override fun onViewBinding(): ActivityAboutBinding =
        ActivityAboutBinding.inflate(layoutInflater)

    override fun onCreated(savedInstanceState: Bundle?) {
        initView()
        initClick()

        viewModel.setEvent(AboutEvent.USER)
    }

    private fun initView() {
        setSupportActionBar(viewBinding.mtlAbout)
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setDisplayShowTitleEnabled(false)
        }
    }

    private fun initClick() {
        viewBinding.mtlAbout.setNavigationOnClickListener { finish() }
    }

    override fun onStateObserver() {
        lifecycleScope.launch {
            viewModel.state.collectLatest {
                when (it) {

                    is AboutState.UserData -> setUser(it.user)

                    is AboutState.MessageData ->
                        Snackbar.make(viewBinding.root, it.message.orEmpty(), Snackbar.LENGTH_LONG)
                            .show()

                }
            }
        }
    }

    private fun setUser(user: User) {
        viewBinding.apply {
            aivUserAvatar.load(user.avatar) {
                transformations(CircleCropTransformation())
            }
            mtvUserName.text = user.name
            mtvUserEmail.text = user.email
            mtvUserAbout.text = user.about
        }
    }

}