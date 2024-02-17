package com.github.fajaragungpramana.morent.core.data.remote.house.response

data class HouseResponse(
    val id: Int?,
    val listImages: List<String>?,
    val title: String?,
    val price: String?,
    val address: String?,
    val overview: String?
)