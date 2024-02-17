package com.github.fajaragungpramana.morent.core.data.remote.user

import com.github.fajaragungpramana.morent.core.data.remote.user.response.UserResponse

class UserServiceImpl(private val fakeUserSource: FakeUserSource) : UserService {

    override suspend fun getUser(): UserResponse = fakeUserSource.data

}