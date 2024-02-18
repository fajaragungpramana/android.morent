package com.github.fajaragungpramana.morent.module.detail

import com.github.fajaragungpramana.morent.core.domain.house.model.House

sealed class DetailState {
    data class HouseData(val house: House) : DetailState()
    data class MessageData(val message: String?) : DetailState()
}