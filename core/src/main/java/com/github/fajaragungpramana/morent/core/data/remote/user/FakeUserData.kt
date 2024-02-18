package com.github.fajaragungpramana.morent.core.data.remote.user

import com.github.fajaragungpramana.morent.core.data.remote.user.response.UserResponse

object FakeUserData {

    val data: UserResponse
        get() = UserResponse(
            avatar = "https://avatars.githubusercontent.com/u/47925662?s=400&u=e15d06caa4f49c9427a080c02f03b86f250f8a90&v=4",
            name = "Fajar Agung Pramana",
            email = "fajar.agungpramana77@gmail.com",
            about = "Experienced mobile developer with a strong track record in app development using Kotlin, Swift and Flutter. Over the past 3 years, I've successfully contributed to various projects, specializing in enhancing mobile apps. Proficient in translating complex requirements into clean, bug-free code, I excel in collaborating with cross-functional teams to deliver high-quality mobile apps."
        )

}