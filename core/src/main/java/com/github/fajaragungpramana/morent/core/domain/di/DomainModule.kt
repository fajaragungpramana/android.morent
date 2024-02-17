package com.github.fajaragungpramana.morent.core.domain.di

import com.github.fajaragungpramana.morent.core.data.remote.user.UserRepository
import com.github.fajaragungpramana.morent.core.domain.user.UserInteractor
import com.github.fajaragungpramana.morent.core.domain.user.UserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    fun provideUserUseCase(userRepository: UserRepository): UserUseCase =
        UserInteractor(userRepository)

}