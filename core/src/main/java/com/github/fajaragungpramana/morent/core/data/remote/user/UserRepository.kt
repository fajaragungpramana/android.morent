package com.github.fajaragungpramana.morent.core.data.remote.user

import com.github.fajaragungpramana.morent.core.app.AppResult
import com.github.fajaragungpramana.morent.core.data.remote.user.response.UserResponse
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    suspend fun getUser(): Flow<AppResult<UserResponse>>

}