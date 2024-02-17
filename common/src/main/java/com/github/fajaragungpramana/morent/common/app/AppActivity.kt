package com.github.fajaragungpramana.morent.common.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.github.fajaragungpramana.morent.common.contract.AppState

abstract class AppActivity<VB : ViewBinding> : AppCompatActivity() {

    private lateinit var _viewBinding: VB
    val viewBinding: VB
        get() = _viewBinding

    protected abstract fun onViewBinding(): VB

    protected abstract fun onCreated(savedInstanceState: Bundle?)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!::_viewBinding.isInitialized)
            _viewBinding = onViewBinding()

        setContentView(viewBinding.root)

        onCreated(savedInstanceState)

        if (this is AppState) onStateObserver()
    }

}