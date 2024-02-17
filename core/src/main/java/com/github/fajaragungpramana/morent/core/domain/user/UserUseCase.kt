package com.github.fajaragungpramana.morent.core.domain.user

import com.github.fajaragungpramana.morent.core.app.AppResult
import com.github.fajaragungpramana.morent.core.domain.user.model.User
import kotlinx.coroutines.flow.Flow

interface UserUseCase {

    suspend fun getUser(): Flow<AppResult<User>>

}