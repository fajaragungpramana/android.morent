package com.github.fajaragungpramana.morent.core.data.remote.house

import com.github.fajaragungpramana.morent.core.app.AppResult
import com.github.fajaragungpramana.morent.core.data.remote.house.response.HouseResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class HouseRepository @Inject constructor(private val iHouseDataSource: IHouseDataSource) :
    IHouseRepository {

    override suspend fun getListHouse(): Flow<AppResult<List<HouseResponse>>> = channelFlow {
        val response = iHouseDataSource.getListHouse()
        send(
            if (response.isNotEmpty())
                AppResult.Success(response)
            else
                AppResult.Error("House data is empty")
        )
    }.flowOn(Dispatchers.IO)

}