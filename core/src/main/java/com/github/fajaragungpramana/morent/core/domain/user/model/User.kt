package com.github.fajaragungpramana.morent.core.domain.user.model

import com.github.fajaragungpramana.morent.core.data.remote.user.response.UserResponse

data class User(
    var avatar: String? = null,
    var name: String? = null,
    var email: String? = null,
    var about: String? = null
) {

    companion object {

        fun mapToObject(userResponse: UserResponse): User = User(
            avatar = userResponse.avatar,
            name = userResponse.name,
            email = userResponse.email,
            about = userResponse.about
        )

    }

}