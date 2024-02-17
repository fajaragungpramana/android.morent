package com.github.fajaragungpramana.morent.core.data.remote.house.di

import com.github.fajaragungpramana.morent.core.data.remote.house.FakeHouseData
import com.github.fajaragungpramana.morent.core.data.remote.house.HouseDataSource
import com.github.fajaragungpramana.morent.core.data.remote.house.HouseRepository
import com.github.fajaragungpramana.morent.core.data.remote.house.IHouseDataSource
import com.github.fajaragungpramana.morent.core.data.remote.house.IHouseRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object HouseModule {

    @Provides
    fun provideDataSource(): IHouseDataSource = HouseDataSource(FakeHouseData)

    @Provides
    fun provideRepository(houseDataSource: HouseDataSource): IHouseRepository =
        HouseRepository(houseDataSource)

}