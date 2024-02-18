package com.github.fajaragungpramana.morent.core.domain.house.model

import androidx.recyclerview.widget.DiffUtil
import com.github.fajaragungpramana.morent.core.data.remote.house.response.HouseResponse

data class House(
    var id: Int? = null,
    var listImage: List<String>? = null,
    var title: String? = null,
    var price: String? = null,
    var address: String? = null,
    var overview: String? = null
) {

    companion object {

        val diffUtil = object : DiffUtil.ItemCallback<House>() {

            override fun areContentsTheSame(oldItem: House, newItem: House): Boolean =
                oldItem == newItem

            override fun areItemsTheSame(oldItem: House, newItem: House): Boolean =
                oldItem.id == newItem.id

        }

        fun mapToList(response: List<HouseResponse>): List<House> {
            val data = arrayListOf<House>()
            response.forEach {
                data.add(House(
                    id = it.id,
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