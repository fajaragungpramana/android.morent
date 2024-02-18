package com.github.fajaragungpramana.morent.module.detail

sealed class DetailEvent {
    data class House(val id: Int) : DetailEvent()
}