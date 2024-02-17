package com.github.fajaragungpramana.morent.core.data.remote.user

import com.github.fajaragungpramana.morent.core.data.remote.user.response.UserResponse
import javax.inject.Inject

class UserDataSource @Inject constructor(private val fakeUserSource: FakeUserData) :
    IUserDataSource {

    override suspend fun getUser(): UserResponse = fakeUserSource.data

}