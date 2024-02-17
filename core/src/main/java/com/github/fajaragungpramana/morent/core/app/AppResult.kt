package com.github.fajaragungpramana.morent.core.app

sealed class AppResult<T> {
    data class Success<T>(val data: T) : AppResult<T>()
    data class Error<T>(val message: String) : AppResult<T>()
}