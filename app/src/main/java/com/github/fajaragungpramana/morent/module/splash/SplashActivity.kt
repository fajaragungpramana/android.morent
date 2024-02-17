package com.github.fajaragungpramana.morent.module.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.github.fajaragungpramana.morent.common.app.AppActivity
import com.github.fajaragungpramana.morent.databinding.ActivitySplashBinding
import com.github.fajaragungpramana.morent.module.main.MainActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppActivity<ActivitySplashBinding>() {

    private var keep = true

    override fun onViewBinding(): ActivitySplashBinding {
        installSplashScreen().let {
            it.setKeepOnScreenCondition { keep }
            it.setOnExitAnimationListener {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)

                finish()
            }
        }

        return ActivitySplashBinding.inflate(layoutInflater)
    }

    override fun onCreated(savedInstanceState: Bundle?) {
        Handler(mainLooper).postDelayed({ keep = false }, DELAY)
    }

    private companion object {
        const val DELAY = 3000L
    }

}