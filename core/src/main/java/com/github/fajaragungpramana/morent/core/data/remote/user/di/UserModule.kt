package com.github.fajaragungpramana.morent.core.data.remote.user.di

import com.github.fajaragungpramana.morent.core.data.remote.user.FakeUserData
import com.github.fajaragungpramana.morent.core.data.remote.user.IUserRepository
import com.github.fajaragungpramana.morent.core.data.remote.user.UserRepository
import com.github.fajaragungpramana.morent.core.data.remote.user.IUserDataSource
import com.github.fajaragungpramana.morent.core.data.remote.user.UserDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UserModule {

    @Provides
    fun provideUserDataSource(): IUserDataSource = UserDataSource(FakeUserData)

    @Provides
    fun provideUserRepository(userService: IUserDataSource): IUserRepository =
        UserRepository(userService)

}