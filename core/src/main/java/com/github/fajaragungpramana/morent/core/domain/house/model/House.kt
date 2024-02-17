package com.github.fajaragungpramana.morent.core.domain.house.model

import com.github.fajaragungpramana.morent.core.data.remote.house.response.HouseResponse

data class House(
    var listImage: List<String>? = null,
    var title: String? = null,
    var price: String? = null,
    var address: String? = null,
    var overview: String? = null
) {

    companion object {

        fun mapToList(response: List<HouseResponse>): List<House> {
            val data = arrayListOf<House>()
            response.forEach {
                data.add(House(
                    listImage = it.listImage,
                    title = it.title,
                    price = it.price,
                    address = it.address,
                    overview = it.overview
                ))
            }

            return data
        }

    }

}