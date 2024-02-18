package com.github.fajaragungpramana.morent.module.about

import com.github.fajaragungpramana.morent.core.domain.user.model.User

sealed class AboutState {
    data class UserData(val user: User) : AboutState()

    data class MessageData(val message: String?) : AboutState()
}