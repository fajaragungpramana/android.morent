package com.github.fajaragungpramana.morent.core.data.remote.user

import com.github.fajaragungpramana.morent.core.data.remote.user.response.UserResponse

interface UserService {

    suspend fun getUser(): UserResponse?

}