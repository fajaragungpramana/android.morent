package com.github.fajaragungpramana.morent.core.domain.user

import com.github.fajaragungpramana.morent.core.app.AppResult
import com.github.fajaragungpramana.morent.core.data.remote.user.UserRepository
import com.github.fajaragungpramana.morent.core.domain.user.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

class UserInteractor @Inject constructor(private val userRepository: UserRepository) : UserUseCase {

    override suspend fun getUser(): Flow<AppResult<User>> = channelFlow {
        userRepository.getUser().collectLatest {
            when (it) {
                is AppResult.Success -> send(
                    AppResult.Success(User.mapToObject(it.data))
                )
                is AppResult.Error -> send(
                    AppResult.Error(it.message)
                )
            }
        }
    }

}