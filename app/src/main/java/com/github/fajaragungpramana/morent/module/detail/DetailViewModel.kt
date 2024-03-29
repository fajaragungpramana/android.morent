package com.github.fajaragungpramana.morent.module.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.fajaragungpramana.morent.core.app.AppResult
import com.github.fajaragungpramana.morent.core.domain.house.HouseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val houseUseCase: HouseUseCase) : ViewModel() {

    private val _state by lazy { Channel<DetailState>() }
    val state: Flow<DetailState>
        get() = _state.receiveAsFlow()

    fun setEvent(event: DetailEvent) {
        when (event) {
            is DetailEvent.House -> getHouse(event.id)
        }
    }

    private fun getHouse(id: Int): Job = viewModelScope.launch {
        houseUseCase.getHouse(id).collectLatest {
            when (it) {
                is AppResult.Success -> _state.send(DetailState.HouseData(it.data))
                is AppResult.Error -> _state.send(DetailState.MessageData(it.message))
            }
        }
    }

}