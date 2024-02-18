package com.github.fajaragungpramana.morent.core.domain.house

import com.github.fajaragungpramana.morent.core.app.AppResult
import com.github.fajaragungpramana.morent.core.data.remote.house.IHouseRepository
import com.github.fajaragungpramana.morent.core.domain.house.model.House
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class HouseInteractor @Inject constructor(private val iHouseRepository: IHouseRepository) :
    HouseUseCase {

    override suspend fun getListHouse(): Flow<AppResult<List<House>>> = channelFlow<AppResult<List<House>>> {
        iHouseRepository.getListHouse().collectLatest {
            when (it) {
                is AppResult.Success -> send(
                    AppResult.Success(House.mapToList(it.data))
                )

                is AppResult.Error -> send(
                    AppResult.Error(it.message)
                )
            }
        }
    }.flowOn(Dispatchers.IO)

}