package com.github.fajaragungpramana.morent.module.main

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
class MainViewModel @Inject constructor(private val userUseCase: UserUseCase) : ViewModel() {

    private val _state by lazy { Channel<MainState>() }
    val state: Flow<MainState>
        get() = _state.receiveAsFlow()

    fun setEvent(event: MainEvent) {
        when (event) {
            MainEvent.USER -> getUser()
        }
    }

    private fun getUser(): Job = viewModelScope.launch {
        userUseCase.getUser().collectLatest {
            when (it) {
                is AppResult.Success -> _state.send(MainState.UserData(it.data))
                is AppResult.Error -> _state.send(MainState.MessageData(it.message))
            }
        }
    }

}