package com.github.fajaragungpramana.morent.core.domain.house

import com.github.fajaragungpramana.morent.core.app.AppResult
import com.github.fajaragungpramana.morent.core.domain.house.model.House
import kotlinx.coroutines.flow.Flow

interface HouseUseCase {

    suspend fun getListHouse(): Flow<AppResult<List<House>>>

    suspend fun getHouse(id: Int): Flow<AppResult<House>>

}