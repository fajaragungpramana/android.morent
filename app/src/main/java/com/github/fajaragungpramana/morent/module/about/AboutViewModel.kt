package com.github.fajaragungpramana.morent.module.about

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.fajaragungpramana.morent.core.app.AppResult
import com.github.fajaragungpramana.morent.core.domain.user.UserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AboutViewModel @Inject constructor(private val userUseCase: UserUseCase) : ViewModel() {

    private val _state by lazy { Channel<AboutState>() }
    val state: Flow<AboutState>
        get() = _state.receiveAsFlow()

    fun setEvent(event: AboutEvent) {
        when (event) {
            AboutEvent.USER -> getUser()
        }
    }

    private fun getUser(): Job = viewModelScope.launch {
        userUseCase.getUser().collectLatest {
            when (it) {
                is AppResult.Success -> _state.send(AboutState.UserData(it.data))
                is AppResult.Error -> _state.send(AboutState.MessageData(it.message))
            }
        }
    }

}