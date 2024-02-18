package com.github.fajaragungpramana.morent.core.data.remote.user

import com.github.fajaragungpramana.morent.core.data.remote.user.response.UserResponse

interface IUserDataSource {

    suspend fun getUser(): UserResponse?

}