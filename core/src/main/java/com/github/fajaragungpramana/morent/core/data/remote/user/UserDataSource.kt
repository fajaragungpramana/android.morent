package com.github.fajaragungpramana.morent.core.data.remote.user

import com.github.fajaragungpramana.morent.core.data.remote.user.response.UserResponse
import javax.inject.Inject

class UserDataSource @Inject constructor(private val fakeUserData: FakeUserData) :
    IUserDataSource {

    override suspend fun getUser(): UserResponse = fakeUserData.data

}