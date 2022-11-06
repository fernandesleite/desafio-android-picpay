package com.picpay.desafio.android.util

sealed class ResponseState<T>(val data: T? = null, val message: Exception? = null) {
    class Success<T>(data: T): ResponseState<T>(data)
    class NetworkError<T>(error: Exception?): ResponseState<T>(null, error)
    class GenericError<T>(error: Exception?): ResponseState<T>(null, error)
}
