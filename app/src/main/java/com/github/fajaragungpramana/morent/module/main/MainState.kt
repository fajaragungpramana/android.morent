package com.github.fajaragungpramana.morent.module.main

import com.github.fajaragungpramana.morent.core.domain.house.model.House
import com.github.fajaragungpramana.morent.core.domain.user.model.User

sealed class MainState {

    data class UserData(val user: User) : MainState()
    data class HouseData(val listHouse: List<House>) : MainState()

    data class MessageData(val message: String?) : MainState()

}