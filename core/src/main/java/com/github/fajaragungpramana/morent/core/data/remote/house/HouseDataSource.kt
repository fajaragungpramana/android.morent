package com.github.fajaragungpramana.morent.core.data.remote.house

import com.github.fajaragungpramana.morent.core.data.remote.house.response.HouseResponse
import javax.inject.Inject

class HouseDataSource @Inject constructor(private val fakeHouseData: FakeHouseData) : IHouseDataSource {

    override suspend fun getListHouse(): List<HouseResponse> = fakeHouseData.data

}