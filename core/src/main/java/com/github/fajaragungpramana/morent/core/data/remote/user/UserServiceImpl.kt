package com.github.fajaragungpramana.morent.core.data.remote.user

import com.github.fajaragungpramana.morent.core.data.remote.user.response.UserResponse
import javax.inject.Inject

class UserServiceImpl @Inject constructor(private val fakeUserSource: FakeUserSource) :
    UserService {

    override suspend fun getUser(): UserResponse = fakeUserSource.data

}