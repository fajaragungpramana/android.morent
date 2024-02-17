package com.github.fajaragungpramana.morent.core.data.remote.user

import com.github.fajaragungpramana.morent.core.app.AppResult
import com.github.fajaragungpramana.morent.core.data.remote.user.response.UserResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UserRepositoryImpl(private val userService: UserService) : UserRepository {

    override suspend fun getUser(): Flow<AppResult<UserResponse>> {
        val response = userService.getUser()
        return flow {
            emit(
                if (response != null)
                    AppResult.Success(response)
                else
                    AppResult.Error(NullPointerException("User data is null."))
            )
        }
    }

}