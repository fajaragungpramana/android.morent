package com.github.fajaragungpramana.morent.core.data.remote.user

import com.github.fajaragungpramana.morent.core.app.AppResult
import com.github.fajaragungpramana.morent.core.data.remote.user.response.UserResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class UserRepository @Inject constructor(private val userService: IUserDataSource) :
    IUserRepository {

    override suspend fun getUser(): Flow<AppResult<UserResponse>> = channelFlow {
        val response = userService.getUser()
        send(
            if (response != null)
                AppResult.Success(response)
            else
                AppResult.Error("User data is null.")
        )
    }.flowOn(Dispatchers.IO)

}