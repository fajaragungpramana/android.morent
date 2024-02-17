package com.github.fajaragungpramana.morent.core.data.remote.user.di

import com.github.fajaragungpramana.morent.core.data.remote.user.FakeUserSource
import com.github.fajaragungpramana.morent.core.data.remote.user.UserRepository
import com.github.fajaragungpramana.morent.core.data.remote.user.UserRepositoryImpl
import com.github.fajaragungpramana.morent.core.data.remote.user.UserService
import com.github.fajaragungpramana.morent.core.data.remote.user.UserServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UserModule {

    @Provides
    fun provideUserService(): UserService = UserServiceImpl(FakeUserSource)

    @Provides
    fun provideUserRepository(userService: UserService): UserRepository =
        UserRepositoryImpl(userService)

}