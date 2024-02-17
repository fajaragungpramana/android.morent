package com.github.fajaragungpramana.morent.core.data.remote.house

import com.github.fajaragungpramana.morent.core.app.AppResult
import com.github.fajaragungpramana.morent.core.data.remote.house.response.HouseResponse
import kotlinx.coroutines.flow.Flow

interface IHouseRepository {

    suspend fun getListHouse(): Flow<AppResult<List<HouseResponse>>>

}