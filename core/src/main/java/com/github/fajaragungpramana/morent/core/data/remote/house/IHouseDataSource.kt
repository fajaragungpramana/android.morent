package com.github.fajaragungpramana.morent.core.data.remote.house

import com.github.fajaragungpramana.morent.core.data.remote.house.response.HouseResponse

interface IHouseDataSource {

    suspend fun getListHouse(): List<HouseResponse>

    suspend fun getHouse(id: Int): HouseResponse?

}